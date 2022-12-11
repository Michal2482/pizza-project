package com.example.pizzaproject.repository;


import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.model.DescriptionOnPages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DescriptionOnPagesRepository extends JpaRepository<DescriptionOnPages,Long> {

    Optional<DescriptionOnPages> findByCompanyPrefix(String prefix);

    void deleteByCompanyPrefix(String prefix);
}
