package com.example.pizzaproject.service;

import com.example.pizzaproject.InMemoryTest;
import com.example.pizzaproject.exceptions.PizzaProjectException;
import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.repository.AdvertRepository;
import com.example.pizzaproject.repository.CompanyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;



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
        Company company = new Company(10L, "prefix", new HashSet<Advert>(), null, null, null);
        companyRepository.save(company);
        Advert expectedAdvert = new Advert(1L, company, "photo", "slogan", "Mexik", "with potatoes");

        advertService.addAdvert(expectedAdvert, "prefix", "photo");
        Optional<Advert> actualAdvert = advertRepository.findById(1L);

        assertTrue(actualAdvert.isPresent());
        assertThat(actualAdvert.stream().map(advert -> advert.getPhotoAdvert()).findFirst().get()).isEqualTo(expectedAdvert.getPhotoAdvert());
        assertThat(actualAdvert.stream().map(advert -> advert.getCompany()).findFirst().get()).isEqualTo(expectedAdvert.getCompany());
    }

    @Test
    public void shouldThrowExceptionWhenCompanyNotExists() {
        Advert advert = new Advert();

        assertThatThrownBy(() -> advertService.addAdvert(advert, "prefixNotExists", "photo"))
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

    @ParameterizedTest
    @MethodSource("provideAdverts")
    void shouldGetAdvert(Long id,String productAdvertName, String slogan, Long companyId) {
        Advert advert = advertService.getAdvert(id);

        assertThat(advert.getId()).isEqualTo(id);
        assertThat(advert.getProductAdvertName()).isEqualTo(productAdvertName);
        assertThat(advert.getSlogan()).isEqualTo(slogan);
        assertThat(advert.getCompany().getId()).isEqualTo(companyId);

    }

    private static Stream<Arguments> provideAdverts() {
        return Stream.of(
                Arguments.of(11111L,"Italian Pizza","Great",9999L),
                Arguments.of(11112L,"Poland Pizza", "Pyszna",9999L),
                Arguments.of(99991L,"Diablo Pizza", "Nice",8888L),
                Arguments.of(99992L,"Chicken Pizza", "Delicious",8888L)
        );
    }

    @Test
    void shouldGetListOfAdverts () {
        Company existCompany = new Company(11L,"existPizzeria",null,null,null,null);
        companyRepository.save(existCompany);
        Advert advertA = new Advert(100L,existCompany,"photo.jpg","Delicious","Pizza","with chicken");
        Advert advertB = new Advert(200L,existCompany,"photo2.jpg","Tasty","Juice","with apple");
        advertService.addAdvert(advertA,"existPizzeria","photo.jpg");
        advertService.addAdvert(advertB,"existPizzeria","photo.jpg");

        System.out.println(advertService.getAdverts("existPizzeria"));
        List<Advert> adverts = advertService.getAdverts("existPizzeria");

        org.assertj.core.api.Assertions.assertThat(adverts)
                .hasSize(2);

    }

    @Test
    void shouldNotGetListOfAdverts_wrongCompany () {
        Company existCompany = new Company(11L,"existPizzeria",null,null,null,null);
        companyRepository.save(existCompany);
        Advert advertA = new Advert(100L,existCompany,"photo.jpg","Delicious","Pizza","with chicken");
        Advert advertB = new Advert(200L,existCompany,"photo2.jpg","Tasty","Juice","with apple");
        advertService.addAdvert(advertA,"existPizzeria","photo.jpg");
        advertService.addAdvert(advertB,"existPizzeria","photo.jpg");

        assertThatThrownBy(()->advertService.getAdverts("notExistPizzeria"))
                .isInstanceOf(PizzaProjectException.class)
                .hasMessageContaining("notExistPizzeria");
    }
}