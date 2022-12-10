package com.example.pizzaproject.service;

import com.example.pizzaproject.exceptions.PizzaProjectException;
import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.repository.BasicInformationRepository;
import com.example.pizzaproject.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BasicInformationService {
    private final BasicInformationRepository basicInformationRepository;
    private final CompanyRepository companyRepository;

    public BasicInformationService(BasicInformationRepository basicInformationRepository, CompanyRepository companyRepository) {
        this.basicInformationRepository = basicInformationRepository;
        this.companyRepository = companyRepository;
    }

    public BasicInformation getInformation(String prefix) {
        return basicInformationRepository.findByCompanyPrefix(prefix).orElse(null);
    }

    @Transactional
    public void addBasicInformation(BasicInformation basicInformation, String prefix) {
        BasicInformation inDataBase = basicInformationRepository.findByCompanyPrefix(prefix).orElseGet(() ->
                basicInformationRepository.save(new BasicInformation()));
        inDataBase.setCompany(companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix)));
        inDataBase.setFirstPartName(basicInformation.getFirstPartName());
        inDataBase.setSecondPartName(basicInformation.getSecondPartName());
        inDataBase.setPhoneNumber(basicInformation.getPhoneNumber());
        inDataBase.setEmail(basicInformation.getEmail());
        inDataBase.setZipCode(basicInformation.getZipCode());
        inDataBase.setCity(basicInformation.getCity());
        inDataBase.setStreet(basicInformation.getStreet());
        inDataBase.setPropertyNumber(basicInformation.getPropertyNumber());

        inDataBase.setOpenHoursMondayFrom(basicInformation.getOpenHoursMondayFrom());
        inDataBase.setOpenHoursMondayTo(basicInformation.getOpenHoursMondayTo());
        inDataBase.setOpenHoursTuesdayFrom(basicInformation.getOpenHoursTuesdayFrom());
        inDataBase.setOpenHoursTuesdayTo(basicInformation.getOpenHoursTuesdayTo());
        inDataBase.setOpenHoursWednesdayFrom(basicInformation.getOpenHoursWednesdayFrom());
        inDataBase.setOpenHoursWednesdayTo(basicInformation.getOpenHoursWednesdayTo());
        inDataBase.setOpenHoursThursdayFrom(basicInformation.getOpenHoursThursdayFrom());
        inDataBase.setOpenHoursThursdayTo(basicInformation.getOpenHoursThursdayTo());
        inDataBase.setOpenHoursFridayFrom(basicInformation.getOpenHoursFridayFrom());
        inDataBase.setOpenHoursFridayTo(basicInformation.getOpenHoursFridayTo());
        inDataBase.setOpenHoursSaturdayFrom(basicInformation.getOpenHoursSaturdayFrom());
        inDataBase.setOpenHoursSaturdayTo(basicInformation.getOpenHoursSaturdayTo());
        inDataBase.setOpenHoursSundayFrom(basicInformation.getOpenHoursSundayFrom());
        inDataBase.setOpenHoursSundayTo(basicInformation.getOpenHoursSundayTo());

        inDataBase.setTwitterUrl(basicInformation.getTwitterUrl());
        inDataBase.setFacebookUrl(basicInformation.getFacebookUrl());
        inDataBase.setInstagramUrl(basicInformation.getInstagramUrl());
        inDataBase.setShortDescriptionPizzeria(basicInformation.getShortDescriptionPizzeria());
    }

    public void deleteBasicInformation(String prefix) {
        Long id = basicInformationRepository.findByCompanyPrefix(prefix).stream().map(company -> company.getId()).findFirst().orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix));
        basicInformationRepository.deleteById(id);
    }
}
