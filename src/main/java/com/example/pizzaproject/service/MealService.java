package com.example.pizzaproject.service;

import com.example.pizzaproject.config.StorageProperties;
import com.example.pizzaproject.exceptions.PizzaProjectException;
import com.example.pizzaproject.exceptions.StorageException;
import com.example.pizzaproject.exceptions.StorageFileNotFoundException;
import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.repository.CategoryRepository;
import com.example.pizzaproject.repository.CompanyRepository;
import com.example.pizzaproject.repository.MealRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MealService {
    private final MealRepository mealRepository;
    private final CategoryRepository categoryRepository;
    private final CompanyRepository companyRepository;

    private final Path rootLocation;

    public MealService(MealRepository mealRepository, CategoryRepository categoryRepository, CompanyRepository companyRepository, StorageProperties properties) {
        this.mealRepository = mealRepository;
        this.categoryRepository = categoryRepository;
        this.companyRepository = companyRepository;
        this.rootLocation = Paths.get(properties.getLocation());
    }

//    public void addMeal(Meal meal, Long categoryId) {
//        Category category = categoryRepository.getById(categoryId);
//        meal.setCategory(category);
//        mealRepository.save(meal);
//    }
    public void addMeal(Meal meal, String prefix, String fileName) {
//        Category category = categoryRepository.getById(categoryId);
//        meal.setCategory(category);
        meal.setCompany(companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix)));
        meal.setPhoto(fileName);
        mealRepository.save(meal);
    }

    public String store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file.");
            }
            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file outside current directory.");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }
            return destinationFile.toString();
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file.", e);
        }
    }


    public List<Meal> getMeals(String prefix) {
        Company companyInDatabase = companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix));
        return mealRepository.findAllByCompanyId(companyInDatabase.getId());                    //met. getMealList w MenuControllerze
    }

    public List<Meal> getMealsWithSearchedText(String prefix, String searchedText) {
        Company companyInDatabase = companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix));
        return mealRepository.findAllByCompanyIdAndSearchedText(companyInDatabase.getId(),searchedText);                    //met. getMealList w MenuControllerze
    }

    public Map<String, List<Meal>> mealByCategories(List<Meal> mealList) {
        return mealList.stream().collect(Collectors.toMap(meal -> meal.getCategory().getCategoryName(),
                meal -> List.of(meal),
                (List<Meal> oldVal, List<Meal> newVal) -> {
                    List<Meal> newList = new ArrayList();
                    newList.addAll(oldVal);
                    newList.addAll(newVal);
                    return newList;
                }
        ));
    }

    public Meal getMeal(Long id) {
        return mealRepository.findById(id).orElse(null);
    }

    @Transactional
    public void editMeal(Meal editedMeal, String prefix, MultipartFile file) {                       //do zapisywania edycji
        Meal storedMeal = mealRepository
                .findById(editedMeal.getId())
                .orElseThrow(() -> new RuntimeException("cannot modify not existing element"));
        String path = Optional.ofNullable(file).map(
                x -> {
                    store(file);
                    return file.getOriginalFilename();
                }
        ).orElseGet(() -> storedMeal.getPhoto());
        storedMeal.setDescription(editedMeal.getDescription());
        storedMeal.setName(editedMeal.getName());
        storedMeal.setPrice(editedMeal.getPrice());
        storedMeal.setCategory(editedMeal.getCategory());
        storedMeal.setPhoto(path);;
    }

    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
        System.out.println("Deleting meal on id " + id);

    }

    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    public Resource loadAsResourceByMealId(Long id) {
        String filename = mealRepository.findById(id).map(meal -> meal.getPhoto()).orElseThrow();
        return loadAsResource(filename);
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

}
