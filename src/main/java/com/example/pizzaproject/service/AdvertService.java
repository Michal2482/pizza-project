package com.example.pizzaproject.service;


import com.example.pizzaproject.exceptions.PizzaProjectException;
import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.repository.AdvertRepository;
import com.example.pizzaproject.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdvertService {
    private final AdvertRepository advertRepository;
    private final CompanyRepository companyRepository;

    public AdvertService(AdvertRepository advertRepository, CompanyRepository companyRepository) {
        this.advertRepository = advertRepository;
        this.companyRepository = companyRepository;
    }

    public void addAdvert(Advert advert, String prefix) {
        advert.setCompany(companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix)));
        advertRepository.save(advert);
    }

    public List<Advert> getAdverts(String prefix) {
        Company companyInDatabase = companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix));
        return advertRepository.findAllByCompanyId(companyInDatabase.getId());
    }


    public Advert getAdvert(Long id) {
        return advertRepository.findById(id).orElse(null);
    }

    public void deleteAdvert(Long id) {
        advertRepository.deleteById(id);
    }

}


