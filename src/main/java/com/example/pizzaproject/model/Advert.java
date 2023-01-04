package com.example.pizzaproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id")
    private Company company;

    private String photoAdvert;


    @Length(max=25,message = "Slogan cannot be longer than 25 signs")
    private String slogan;

    @NotEmpty(message = "Cannot be empty")
    @Length(max=35,message = "Product name cannot be longer than 35 signs")
    private String productAdvertName;

    @Length(max=250,message = "Description cannot be longer than 250 signs")
    private String descriptionProductAdvert;

}
