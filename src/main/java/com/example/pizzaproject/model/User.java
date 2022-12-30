package com.example.pizzaproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="users")
public class User {

    @Id
    @NotNull
    @NotEmpty
    private String username;

    @Column(name="password")
    @NotNull
    @NotEmpty
    private String password;


    @Column(name="role")
    private String role;

    @OneToOne
    private Company company;

    @Column(name="email")
    @Email
    @NotEmpty
    private String email;


}
