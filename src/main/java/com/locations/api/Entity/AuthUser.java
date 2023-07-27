package com.locations.api.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

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

    @Column()
    private Role role;

    public AuthUser(String authUserId, String username, String password, String accessToken, String refreshToken) {
        this.authUserId = authUserId;
        this.username = username;
        this.password = password;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public AuthUser () {}
}