package com.example.pizzaproject.service;

import com.example.pizzaproject.exceptions.PizzaProjectException;
import com.example.pizzaproject.model.Category;
import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.repository.CategoryRepository;
import com.example.pizzaproject.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CompanyRepository companyRepository;

    public CategoryService(CategoryRepository categoryRepository, CompanyRepository companyRepository) {
        this.categoryRepository = categoryRepository;
        this.companyRepository = companyRepository;
    }

    public void addCategory(Category category, String prefix) {
        category.setCompany(companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix)));
        categoryRepository.save(category);
    }
    public List<Category> getCategories(String prefix) {
        Company companyInDatabase = companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix));
        return categoryRepository.findAllByCompanyId(companyInDatabase.getId());
    }
    public Category getCategory(Long id) {                                  //dlaczego taki typ?
        return categoryRepository.findById(id).orElse(null);
    }
    public void editCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id, String prefix) {
        categoryRepository.deleteById(id);
        System.out.println("Deleting category on id "+ id);
    }
}
