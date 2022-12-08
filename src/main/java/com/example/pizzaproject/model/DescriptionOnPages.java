package com.example.pizzaproject.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class DescriptionOnPages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    private Company company;

    private String shortDescriptionHomePage;
    private String shortDescriptionMenuPage;
    private String shortDescriptionServicesPage;
}
