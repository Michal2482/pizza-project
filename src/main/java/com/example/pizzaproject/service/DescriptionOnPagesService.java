package com.example.pizzaproject.service;

import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.model.DescriptionOnPages;
import com.example.pizzaproject.repository.DescriptionOnPagesRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DescriptionOnPagesService {

    private final DescriptionOnPagesRepository descriptionOnPagesRepository;

    public DescriptionOnPagesService(DescriptionOnPagesRepository descriptionOnPagesRepository) {
        this.descriptionOnPagesRepository = descriptionOnPagesRepository;
    }

    public DescriptionOnPages getInformation(String prefix) {
        return descriptionOnPagesRepository.findByCompanyPrefix(prefix).orElse(null);
    }

    @Transactional
    public void addDescriptionOnPages(DescriptionOnPages descriptionOnPages, String prefix) {
        DescriptionOnPages inDataBase = descriptionOnPagesRepository.findByCompanyPrefix(prefix).orElseGet(() ->
                descriptionOnPagesRepository.save(new DescriptionOnPages()));
        inDataBase.setShortDescriptionHomePage(descriptionOnPages.getShortDescriptionHomePage());
        inDataBase.setShortDescriptionMenuPage(descriptionOnPages.getShortDescriptionMenuPage());
        inDataBase.setShortDescriptionServicesPage(descriptionOnPages.getShortDescriptionServicesPage());
    }

    public void deleteDescriptionOnPages(String prefix) {
        descriptionOnPagesRepository.deleteByCompanyPrefix(prefix);
    }
}
