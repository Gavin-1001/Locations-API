package com.locations.api.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    ///ADDED THIS ENTITY CLASS. SEE THE AUTH_USER SERVICE
    ///TRYING TO PASS FIRSTNAME, LASTNAME etc from auth user and set it
    ///to the USER.

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="authUserId", referencedColumnName = "id")
//    private AuthUser authUser;
}
