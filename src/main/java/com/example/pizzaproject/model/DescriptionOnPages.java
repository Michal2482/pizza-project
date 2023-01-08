package com.example.pizzaproject.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DescriptionOnPages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    private Company company;


    @Lob
    private String longDescriptionHomePage;

    private String shortDescriptionMenuPage;

    private String shortDescriptionServicesPage;
}
