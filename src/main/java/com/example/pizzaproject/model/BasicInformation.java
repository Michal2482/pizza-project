package com.example.pizzaproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.time.LocalTime;

@Entity
public class BasicInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String firstPartName;
    private String secondPartName;
    private String phoneNumber;
    @Email
    private String email;
    private String city;
    private String street;
    private String propertyNumber;
    private LocalTime openHoursMondayFrom;
    private LocalTime openHoursMondayTo;
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
