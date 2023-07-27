package com.locations.api.Security;

import com.locations.api.Entity.AuthUser;
import com.locations.api.Services.AuthService.AuthenticationService;
import com.locations.api.Services.UserService.UserService;
import com.locations.api.Utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public abstract class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authenticationService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(authUser.getRole().name()));

        return UserPrincipal.builder()
                .authUser(authUser)
                .id(authUser.getAuthUserId())
                .username(authUser.getUsername())
                .password(authUser.getPassword())
                .authorities(authorities)
                .build();
    }
}
