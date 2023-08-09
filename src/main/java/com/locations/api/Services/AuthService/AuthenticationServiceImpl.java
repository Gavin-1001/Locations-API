package com.locations.api.Services.AuthService;


import com.locations.api.Entity.AuthUser;
import com.locations.api.Entity.Role;
import com.locations.api.Repository.AuthUserRepository;
import com.locations.api.Security.Jwt.JwtProvider;
import com.locations.api.Security.UserPrincipal;
import com.locations.api.Services.JwtRefreshTokenService.JwtRefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthUserRepository userAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private JwtRefreshTokenService jwtRefreshTokenService;


    @Override
    public AuthUser signInAndReturnJWT(AuthUser signInRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        AuthUser signInUser = userPrincipal.getAuthUser();
        signInUser.setAccessToken(jwt);
        signInUser.setRefreshToken(jwtRefreshTokenService.createRefreshToken(signInUser.getAuthUserId()).getTokenId());

        return signInUser;
    }

    @Override
    public Optional<AuthUser> findByUsername(String username) {
        return userAuthRepository.findByUsername(username);
    }

    @Override
    public AuthUser saveUser(AuthUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //if statement for user or employer was here
        user.setRole(Role.USER);

        return userAuthRepository.save(user);

    }

}
