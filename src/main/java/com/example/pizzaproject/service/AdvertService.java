package com.example.pizzaproject.service;


import com.example.pizzaproject.exceptions.PizzaProjectException;
import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.repository.AdvertRepository;
import com.example.pizzaproject.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdvertService {
    private final AdvertRepository advertRepository;
    private final CompanyRepository companyRepository;

    public AdvertService(AdvertRepository advertRepository, CompanyRepository companyRepository) {
        this.advertRepository = advertRepository;
        this.companyRepository = companyRepository;
    }

    public Advert getInformation(String prefix) {
        return advertRepository.findByCompanyPrefix(prefix).orElse(null);
    }

    @Transactional
    public void addAdvert(Advert advert, String prefix) {
        Advert inDataBase =advertRepository.findByCompanyPrefix(prefix).orElseGet(() ->
                advertRepository.save(new Advert()));
        inDataBase.setCompany(companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix)));
        inDataBase.setPhotoAdvert(advert.getPhotoAdvert());
        inDataBase.setSlogan(advert.getSlogan());
        inDataBase.setProductAdvertName(advert.getProductAdvertName());
        inDataBase.setDescriptionProductAdvert(advert.getDescriptionProductAdvert());
    }

    public void deleteAdvert(String prefix) {
        advertRepository.deleteByCompanyPrefix(prefix);
    }
}
