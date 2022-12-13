package com.example.pizzaproject.model;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photo;
    private String name;
    private String surname;
    private String job;

    public Person(Long id, String photo, String name, String surname, String job, String description) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.description = description;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id")
    private Company company;

    public Person() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
