package com.example.pizzaproject.repository;


import com.example.pizzaproject.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository <Services, Long>{
  }
