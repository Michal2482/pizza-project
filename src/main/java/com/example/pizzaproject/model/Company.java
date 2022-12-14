package com.example.pizzaproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prefix;

    @OneToMany(mappedBy="company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Advert> adverts = new HashSet<>();

    @OneToMany(mappedBy="company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy="company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Meal> meals = new HashSet<>();

    @OneToMany(mappedBy="company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Person> persons = new HashSet<>();
}
