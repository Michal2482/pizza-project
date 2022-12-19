package com.example.pizzaproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="users")
public class User {

    @Id
    @NonNull
    @NotEmpty
    private String username;

    @Column(name="password")
    @NonNull
    @NotEmpty
    private String password;


    @Column(name="role")
    private String role;

//    @Column(name="email")
//    @NonNull
//    @NotEmpty
//    private String email;


}
