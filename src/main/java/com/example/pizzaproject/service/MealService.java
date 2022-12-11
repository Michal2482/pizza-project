package com.example.pizzaproject.service;

import com.example.pizzaproject.exceptions.PizzaProjectException;
import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.repository.CategoryRepository;
import com.example.pizzaproject.repository.CompanyRepository;
import com.example.pizzaproject.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;
    private final CategoryRepository categoryRepository;
    private final CompanyRepository companyRepository;

    public MealService(MealRepository mealRepository, CategoryRepository categoryRepository, CompanyRepository companyRepository) {
        this.mealRepository = mealRepository;
        this.categoryRepository = categoryRepository;
        this.companyRepository = companyRepository;
    }

//    public void addMeal(Meal meal, Long categoryId) {
//        Category category = categoryRepository.getById(categoryId);
//        meal.setCategory(category);
//        mealRepository.save(meal);
//    }
    public void addMeal(Meal meal, String prefix) {
//        Category category = categoryRepository.getById(categoryId);
//        meal.setCategory(category);
        meal.setCompany(companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix)));
        mealRepository.save(meal);
    }


    public List<Meal> getMeals() {                          //pobiera wszystkie dania, korzysta z niej
        return mealRepository.findAll();                    //met. getMealList w MenuControllerze
    }

    public Meal getMeal(Long id) {
        return mealRepository.findById(id).orElse(null);
    }

    public void editMeal(Meal meal) {                       //do zapisywania edycji
        mealRepository.save(meal);
    }

    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
        System.out.println("Deleting meal on id " + id);

    }


}
