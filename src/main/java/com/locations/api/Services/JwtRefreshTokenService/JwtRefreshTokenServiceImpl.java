package com.locations.api.Services.JwtRefreshTokenService;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.tokens.Token;

@Service
public class JwtRefreshTokenServiceImpl implements JwtRefreshTokenService{
    @Override
    public Token createRefreshToken(String authUserId) {
        return null;
    }
}
