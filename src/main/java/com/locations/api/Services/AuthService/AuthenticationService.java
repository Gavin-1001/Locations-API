package com.locations.api.Services.AuthService;


import com.locations.api.Entity.AuthUser;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;

import java.util.Optional;

public interface AuthenticationService {
    Optional<AuthUser> findByUsername(String username);

    AuthUser saveUser(AuthUser authUser);

    AuthUser signInAndReturnJWT(AuthUser signInRequest);


}
