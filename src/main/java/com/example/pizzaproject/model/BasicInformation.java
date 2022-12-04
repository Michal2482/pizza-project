package com.example.pizzaproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalTime;


@Getter
@Setter
@Entity
public class BasicInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    private Company company;

    private String firstPartName;
    private String secondPartName;
    private String phoneNumber;
    @Email
    private String email;
    private String city;
    private String street;
    private String propertyNumber;
//    private List<OpenHours> openHours; list.add, list.
    private String openHoursMondayFrom;
    private String openHoursMondayTo;
    private LocalTime openHoursTuesdayFrom;
    private LocalTime openHoursTuesdayTo;
    private LocalTime openHoursWednesdayFrom;
    private LocalTime openHoursWednesdayTo;
    private LocalTime openHoursThursdayFrom;
    private LocalTime openHoursThursdayTo;
    private LocalTime openHoursFridayFrom;
    private LocalTime openHoursFridayTo;
    private LocalTime openHoursSaturdayFrom;
    private LocalTime openHoursSaturdayTo;
    private LocalTime openHoursSundayFrom;
    private LocalTime openHoursSundayTo;
    private String twitterUrl;
    private String facebookUrl;
    private String instagramUrl;



}
