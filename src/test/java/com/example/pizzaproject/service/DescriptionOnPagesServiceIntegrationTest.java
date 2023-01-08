package com.example.pizzaproject.service;

import com.example.pizzaproject.InMemoryTest;
import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.model.DescriptionOnPages;
import com.example.pizzaproject.repository.CompanyRepository;
import com.example.pizzaproject.repository.DescriptionOnPagesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "/descriptionOnPagesTest.sql")
@WithMockUser(username = "pizzaOwner",password = "$2a$10$8tGbHaO0kVbnbyVx5kcGT.52IJDsf0ErRkZVoudDLCnueReAW7NOu",roles = "PIZZERIA_OWNER")
class DescriptionOnPagesServiceIntegrationTest extends InMemoryTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DescriptionOnPagesService descriptionOnPagesService;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    CompanyRepository companyRepository;

    @Test
    public void testGetDescriptionOnPagesForm() throws Exception {
        DescriptionOnPages descriptionOnPages = new DescriptionOnPages();
        when(descriptionOnPagesService.getInformation(anyString())).thenReturn(descriptionOnPages);

        mockMvc.perform(get("/{prefix}/admin/descriptionOnPages", "test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("admin/descriptionOnPages"))
                .andExpect(model().attribute("descriptionOnPages", descriptionOnPages));
    }

    @Test
    public void testPostEditDescriptionOnPages() throws Exception {
        Company company = companyRepository.findCompanyByPrefix("pizzunia").get();
        DescriptionOnPages descriptionOnPagesTest = new DescriptionOnPages();
        descriptionOnPagesTest.setShortDescriptionMenuPage("new description");
        descriptionOnPagesTest.setCompany(company);
        descriptionOnPagesTest.setId(123L);


        mockMvc.perform(post("/{prefix}/admin/descriptionOnPages?submitAndGoAdminPage", "pizzunia")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(descriptionOnPagesTest)))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(model().hasNoErrors());
    }

}