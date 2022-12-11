package com.example.pizzaproject.repository;

import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findAllByCompanyId(Long id);
}
