package com.example.pizzaproject.service;

import com.example.pizzaproject.exceptions.PizzaProjectException;
import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.repository.BasicInformationRepository;
import com.example.pizzaproject.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BasicInformationServiceTest {
    private static final String PREFIX = "prefix";

    private Company company = mock(Company.class);
    @Mock
    private BasicInformation basicInformation;

    @Mock
    private BasicInformationRepository basicInformationRepository;

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private BasicInformationService basicInformationService;

    @Test
    void shouldGetInformation() {

        //given
        when(basicInformationRepository.findByCompanyPrefix(PREFIX)).thenReturn(Optional.of(basicInformation));

        //when
       BasicInformation actualBasicInformation = basicInformationService.getInformation(PREFIX);

        //then
        verify(basicInformationRepository).findByCompanyPrefix(PREFIX);
        assertThat(actualBasicInformation).isEqualTo(basicInformation);
        verifyNoInteractions(companyRepository);

    }

    @Test
    void shouldThrowWhenCompanyNotExist() {
        //given
        when(companyRepository.findCompanyByPrefix(PREFIX)).thenReturn(Optional.empty());

        //when
        assertThatExceptionOfType(PizzaProjectException.class)
                .isThrownBy(() -> basicInformationService.addBasicInformation(basicInformation,PREFIX));

        //then
      verify(basicInformationRepository).findByCompanyPrefix(PREFIX);

    }

    @Test
    public void shouldChangeExistingBasicInformation() {
        BasicInformation existingBasicInformation = mock(BasicInformation.class);
        when(basicInformationRepository.findByCompanyPrefix(PREFIX)).thenReturn(Optional.of(existingBasicInformation));
        when(companyRepository.findCompanyByPrefix(PREFIX)).thenReturn(Optional.of(company));

        basicInformationService.addBasicInformation(basicInformation, PREFIX);

        verify(basicInformationRepository, never()).save(basicInformation);
        verifyNoMoreInteractions(basicInformationRepository);
        verify(existingBasicInformation).setCompany(company);
        verify(existingBasicInformation).setFirstPartName(basicInformation.getFirstPartName());
        verify(existingBasicInformation).setSecondPartName(basicInformation.getSecondPartName());
        verify(existingBasicInformation).setPhoneNumber(basicInformation.getPhoneNumber());
        verify(existingBasicInformation).setEmail(basicInformation.getEmail());
        verify(existingBasicInformation).setZipCode(basicInformation.getZipCode());
        verify(existingBasicInformation).setCity(basicInformation.getCity());
        verify(existingBasicInformation).setStreet(basicInformation.getStreet());
        verify(existingBasicInformation).setPropertyNumber(basicInformation.getPropertyNumber());
        verify(existingBasicInformation).setOpenHoursMondayFrom(basicInformation.getOpenHoursMondayFrom());
        verify(existingBasicInformation).setOpenHoursMondayTo(basicInformation.getOpenHoursMondayTo());
        verify(existingBasicInformation).setOpenHoursTuesdayFrom(basicInformation.getOpenHoursTuesdayFrom());
        verify(existingBasicInformation).setOpenHoursTuesdayTo(basicInformation.getOpenHoursTuesdayTo());
        verify(existingBasicInformation).setOpenHoursWednesdayFrom(basicInformation.getOpenHoursWednesdayFrom());
        verify(existingBasicInformation).setOpenHoursWednesdayTo(basicInformation.getOpenHoursWednesdayTo());
        verify(existingBasicInformation).setOpenHoursThursdayFrom(basicInformation.getOpenHoursThursdayFrom());
        verify(existingBasicInformation).setOpenHoursThursdayTo(basicInformation.getOpenHoursThursdayTo());
        verify(existingBasicInformation).setOpenHoursFridayFrom(basicInformation.getOpenHoursFridayFrom());
        verify(existingBasicInformation).setOpenHoursFridayTo(basicInformation.getOpenHoursFridayTo());
        verify(existingBasicInformation).setOpenHoursSaturdayFrom(basicInformation.getOpenHoursSaturdayFrom());
        verify(existingBasicInformation).setOpenHoursSaturdayTo(basicInformation.getOpenHoursSaturdayTo());
        verify(existingBasicInformation).setOpenHoursSundayFrom(basicInformation.getOpenHoursSundayFrom());
        verify(existingBasicInformation).setOpenHoursSundayTo(basicInformation.getOpenHoursSundayTo());
        verify(existingBasicInformation).setTwitterUrl(basicInformation.getTwitterUrl());
        verify(existingBasicInformation).setFacebookUrl(basicInformation.getFacebookUrl());
        verify(existingBasicInformation).setInstagramUrl(basicInformation.getInstagramUrl());
        verify(existingBasicInformation).setShortDescriptionPizzeria(basicInformation.getShortDescriptionPizzeria());
        assertThat(basicInformation.getCompany()).isEqualTo(existingBasicInformation.getCompany());
        assertThat(basicInformation.getFirstPartName()).isEqualTo(existingBasicInformation.getFirstPartName());
        assertThat(basicInformation.getSecondPartName()).isEqualTo(existingBasicInformation.getSecondPartName());
        assertThat(basicInformation.getPhoneNumber()).isEqualTo(existingBasicInformation.getPhoneNumber());
        assertThat(basicInformation.getEmail()).isEqualTo(existingBasicInformation.getEmail());
        assertThat(basicInformation.getZipCode()).isEqualTo(existingBasicInformation.getZipCode());
        assertThat(basicInformation.getCity()).isEqualTo(existingBasicInformation.getCity());
        assertThat(basicInformation.getStreet()).isEqualTo(existingBasicInformation.getStreet());
        assertThat(basicInformation.getPropertyNumber()).isEqualTo(existingBasicInformation.getPropertyNumber());
        assertThat(basicInformation.getOpenHoursMondayFrom()).isEqualTo(existingBasicInformation.getOpenHoursMondayFrom());
        assertThat(basicInformation.getOpenHoursMondayTo()).isEqualTo(existingBasicInformation.getOpenHoursMondayTo());
        assertThat(basicInformation.getOpenHoursTuesdayFrom()).isEqualTo(existingBasicInformation.getOpenHoursTuesdayFrom());
        assertThat(basicInformation.getOpenHoursTuesdayTo()).isEqualTo(existingBasicInformation.getOpenHoursTuesdayTo());
        assertThat(basicInformation.getOpenHoursWednesdayFrom()).isEqualTo(existingBasicInformation.getOpenHoursWednesdayFrom());
        assertThat(basicInformation.getOpenHoursWednesdayTo()).isEqualTo(existingBasicInformation.getOpenHoursWednesdayTo());
        assertThat(basicInformation.getOpenHoursThursdayFrom()).isEqualTo(existingBasicInformation.getOpenHoursThursdayFrom());
        assertThat(basicInformation.getOpenHoursThursdayTo()).isEqualTo(existingBasicInformation.getOpenHoursThursdayTo());
        assertThat(basicInformation.getOpenHoursFridayFrom()).isEqualTo(existingBasicInformation.getOpenHoursFridayFrom());
        assertThat(basicInformation.getOpenHoursFridayTo()).isEqualTo(existingBasicInformation.getOpenHoursFridayTo());
        assertThat(basicInformation.getOpenHoursSaturdayFrom()).isEqualTo(existingBasicInformation.getOpenHoursSaturdayFrom());
        assertThat(basicInformation.getOpenHoursSaturdayTo()).isEqualTo(existingBasicInformation.getOpenHoursSaturdayTo());
        assertThat(basicInformation.getOpenHoursSundayFrom()).isEqualTo(existingBasicInformation.getOpenHoursSundayFrom());
        assertThat(basicInformation.getOpenHoursSundayTo()).isEqualTo(existingBasicInformation.getOpenHoursSundayTo());
        assertThat(basicInformation.getTwitterUrl()).isEqualTo(existingBasicInformation.getTwitterUrl());
        assertThat(basicInformation.getFacebookUrl()).isEqualTo(existingBasicInformation.getFacebookUrl());
        assertThat(basicInformation.getInstagramUrl()).isEqualTo(existingBasicInformation.getInstagramUrl());
        assertThat(basicInformation.getShortDescriptionPizzeria()).isEqualTo(existingBasicInformation.getShortDescriptionPizzeria());
    }

//    @Test
//    public void addBasicInformationTest() {
//        // given
//        BasicInformation cos = mock(BasicInformation.class);
//
//        when(basicInformationRepository.findByCompanyPrefix(PREFIX)).thenReturn(Optional.empty());
//        when(basicInformationRepository.save(any())).thenReturn(cos);
//        when(companyRepository.findCompanyByPrefix(PREFIX)).thenReturn(Optional.of(company));
//
//
//        // when
//        basicInformationService.addBasicInformation(basicInformation, PREFIX);
//
//        // then
//        verify(basicInformationRepository).save(cos);
//
//    }
}


