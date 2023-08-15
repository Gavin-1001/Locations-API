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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="authUserId", referencedColumnName = "id")
    private AuthUser authUser;
}
