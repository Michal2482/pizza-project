package com.example.pizzaproject.service;

import com.example.pizzaproject.InMemoryTest;
import com.example.pizzaproject.exceptions.PizzaProjectException;
import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.repository.AdvertRepository;
import com.example.pizzaproject.repository.CompanyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Sql(scripts = "/advertTest.sql")
class AdvertServiceTest extends InMemoryTest {

    @Autowired
    AdvertService advertService;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    AdvertRepository advertRepository;



    @Test
    public void shouldAddAdvert() {
        Company company = new Company(10L,"prefix", new HashSet<Advert>(),null,null,null);
        companyRepository.save(company);
        Advert expectedAdvert = new Advert(1L,company,"photo","slogan","Mexik","with potatoes");

        advertService.addAdvert(expectedAdvert,"prefix","photo");
        Optional<Advert> actualAdvert = advertRepository.findById(1L);

        assertTrue(actualAdvert.isPresent());
        assertThat(actualAdvert.stream().map(advert -> advert.getPhotoAdvert()).findFirst().get()).isEqualTo(expectedAdvert.getPhotoAdvert());
        assertThat(actualAdvert.stream().map(advert -> advert.getCompany()).findFirst().get()).isEqualTo(expectedAdvert.getCompany());
    }

    @Test
    public void shouldThrowExceptionWhenCompanyNotExists() {
        Advert advert = new Advert();

       assertThatThrownBy(()->advertService.addAdvert(advert,"prefixNotExists","photo"))
               .isInstanceOf(PizzaProjectException.class);
    }

//    @Test
//    public void addFile() {
//        MultipartFile file = new
//    }

    @Test
    public void shouldSaveUploadedFile() {
        MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
                "text/plain", "Spring Framework".getBytes());


        String expectedFile = advertService.store(multipartFile);
        String actualFile = advertService.load("test.txt").toAbsolutePath().toString();

        assertThat(actualFile).isNotNull()
                .isEqualTo(expectedFile);
    }

}