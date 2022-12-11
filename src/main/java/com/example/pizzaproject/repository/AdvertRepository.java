package com.example.pizzaproject.repository;

import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertRepository extends JpaRepository<Advert,Long> {

    List<Advert> findAllByCompanyId(Long id);
}
