package com.example.pizzaproject.service;

import com.example.pizzaproject.exceptions.PizzaProjectException;
import com.example.pizzaproject.model.DescriptionOnPages;
import com.example.pizzaproject.repository.CompanyRepository;
import com.example.pizzaproject.repository.DescriptionOnPagesRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DescriptionOnPagesService {

    private final DescriptionOnPagesRepository descriptionOnPagesRepository;
    private final CompanyRepository companyRepository;

    public DescriptionOnPagesService(DescriptionOnPagesRepository descriptionOnPagesRepository, CompanyRepository companyRepository) {
        this.descriptionOnPagesRepository = descriptionOnPagesRepository;
        this.companyRepository = companyRepository;
    }

    public DescriptionOnPages getInformation(String prefix) {
        return descriptionOnPagesRepository.findByCompanyPrefix(prefix).orElse(null);
    }

    @Transactional
    public void addDescriptionOnPages(DescriptionOnPages descriptionOnPages, String prefix) {
        DescriptionOnPages inDataBase = descriptionOnPagesRepository.findByCompanyPrefix(prefix).orElseGet(() ->
                descriptionOnPagesRepository.save(new DescriptionOnPages()));
        inDataBase.setCompany(companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix)));

        inDataBase.setLongDescriptionHomePage(descriptionOnPages.getLongDescriptionHomePage());
        inDataBase.setShortDescriptionMenuPage(descriptionOnPages.getShortDescriptionMenuPage());
        inDataBase.setShortDescriptionServicesPage(descriptionOnPages.getShortDescriptionServicesPage());
    }

    public void deleteDescriptionOnPages(String prefix) {
        descriptionOnPagesRepository.deleteByCompanyPrefix(prefix);
    }
}
