package com.locations.api.Security.Jwt;

import com.locations.api.Security.UserPrincipal;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {
    Authentication getAuthentication(HttpServletRequest request);

    Claims extractClaims(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);

    String generateToken(UserPrincipal userPrincipal);
}
