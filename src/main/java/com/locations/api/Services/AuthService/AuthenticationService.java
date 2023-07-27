package com.locations.api.Services.AuthService;


import com.locations.api.Entity.AuthUser;

import java.util.Optional;

public interface AuthenticationService {
    Optional<AuthUser> findByUsername(String username);

    AuthUser saveUser(AuthUser authUser);
}
