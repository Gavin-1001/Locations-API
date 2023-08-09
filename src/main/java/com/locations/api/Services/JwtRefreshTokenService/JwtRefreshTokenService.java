package com.locations.api.Services.JwtRefreshTokenService;

import com.locations.api.Entity.AuthUser;
import com.locations.api.Entity.JwtRefreshToken;

public interface JwtRefreshTokenService {


    JwtRefreshToken createRefreshToken(String authUserId);

    AuthUser generateAccessTokenFromRefreshToken(String refreshTokenId);
}
