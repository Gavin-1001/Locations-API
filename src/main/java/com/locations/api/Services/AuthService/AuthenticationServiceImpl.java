package com.locations.api.Services.AuthService;


import com.locations.api.Entity.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<AuthUser> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public AuthUser saveUser(AuthUser authUser) {
        authUser.setPassword(passwordEncoder.encode(authUser.getPassword()));
        return null;
    }
}
