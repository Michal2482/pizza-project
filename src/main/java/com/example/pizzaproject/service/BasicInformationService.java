package com.example.pizzaproject.service;

import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.repository.BasicInformationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BasicInformationService {
    private final BasicInformationRepository basicInformationRepository;

    public BasicInformationService(BasicInformationRepository basicInformationRepository) {
        this.basicInformationRepository = basicInformationRepository;
    }

    public BasicInformation getInformation(String prefix) {
        return basicInformationRepository.findByCompanyPrefix(prefix).orElse(null);
    }
@Transactional
    public void addBasicInformation(BasicInformation basicInformation, String prefix) {
       BasicInformation inDataBase =  basicInformationRepository.findByCompanyPrefix(prefix).orElse(null);
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
    }
}
