package com.locations.api.Services.JwtRefreshTokenService;

import com.locations.api.Entity.AuthUser;
import com.locations.api.Entity.JwtRefreshToken;
import com.locations.api.Repository.AuthUserRepository;
import com.locations.api.Repository.JwtRefreshTokenRepository;
import com.locations.api.Security.Jwt.JwtProvider;
import com.locations.api.Security.UserPrincipal;
import com.locations.api.Utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.UUID;


@Service
public class JwtRefreshTokenServiceImpl implements JwtRefreshTokenService{

    @Value("86400000")
    private Long REFRESH_EXPIRATION_IN_MS;

    @Autowired
    private JwtRefreshTokenRepository jwtRefreshTokenRepository;

    @Autowired
    private AuthUserRepository authUserRepository;


    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public JwtRefreshToken createRefreshToken(String authUserId) {
        JwtRefreshToken jwtRefreshToken = new JwtRefreshToken();
        jwtRefreshToken.setTokenId(UUID.randomUUID().toString());
        jwtRefreshToken.setUserId(authUserId);
        jwtRefreshToken.setWhenTokenCreated(LocalDateTime.now());
        jwtRefreshToken.setWhenTokenExpirationDate(LocalDateTime.now().plus(REFRESH_EXPIRATION_IN_MS, ChronoUnit.MILLIS));

        return jwtRefreshTokenRepository.save(jwtRefreshToken);
    }

    @Override
    public AuthUser generateAccessTokenFromRefreshToken(String refreshTokenId){
        JwtRefreshToken jwtRefreshToken = jwtRefreshTokenRepository.findById(refreshTokenId).orElseThrow();

        if(jwtRefreshToken.getWhenTokenExpirationDate().isBefore(LocalDateTime.now())){
            throw new RuntimeException("JWT REFRESH TOKEN IS NOT VALID");
        }

        AuthUser user = authUserRepository.findById(jwtRefreshToken.getUserId()).orElseThrow();

        UserPrincipal userPrincipal = UserPrincipal.builder()
                .id(user.getAuthUserId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(Set.of(SecurityUtils.convertToAuthority(user.getRole().name())))
                .build();

        String accessToken = jwtProvider.generateToken(userPrincipal);

        user.setAccessToken(accessToken);
        user.setRefreshToken(refreshTokenId);

        return user;
    }
}
