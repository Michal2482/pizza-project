package com.example.pizzaproject.service;

import com.example.pizzaproject.model.Category;
import com.example.pizzaproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
    public void editCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        System.out.println("Deleting category on id "+ id);
    }
}
