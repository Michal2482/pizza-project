package com.example.pizzaproject.service;

import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.repository.BasicInformationRepository;
import org.springframework.stereotype.Service;

@Service
public class BasicInformationService {
    private final BasicInformationRepository basicInformationRepository;

    public BasicInformationService(BasicInformationRepository basicInformationRepository) {
        this.basicInformationRepository = basicInformationRepository;
    }

    public BasicInformation getInformation() {
        return basicInformationRepository.findById(1L).orElse(null);
    }
}
