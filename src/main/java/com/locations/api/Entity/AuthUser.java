package com.locations.api.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class AuthUser {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String authUserId;


    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Transient
    private String accessToken;

    @Transient
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_locations_id", referencedColumnName = "id")
    private List<Locations> locations;

    public AuthUser(String authUserId, String username, String password) {
        this.authUserId = authUserId;
        this.username = username;
        this.password = password;

    }

    public AuthUser(){}

}
