package com.locations.api.Services.JwtRefreshTokenService;

import org.yaml.snakeyaml.tokens.Token;

public interface JwtRefreshTokenService {


    Token createRefreshToken(String authUserId);
}
