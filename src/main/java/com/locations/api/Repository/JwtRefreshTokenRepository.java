package com.locations.api.Repository;

import com.locations.api.Entity.JwtRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtRefreshTokenRepository extends JpaRepository<JwtRefreshToken, String> {


}
