package com.example.pizzaproject.repository;


import com.example.pizzaproject.model.BasicInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicInformationRepository extends JpaRepository<BasicInformation,Long> {
}
