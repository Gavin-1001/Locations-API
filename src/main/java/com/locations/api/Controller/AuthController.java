package com.locations.api.Controller;


import com.locations.api.Entity.AuthUser;
import com.locations.api.Entity.JwtRefreshToken;
import com.locations.api.Services.AuthService.AuthenticationService;
import com.locations.api.Services.JwtRefreshTokenService.JwtRefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private JwtRefreshTokenService jwtRefreshTokenService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody AuthUser authUser) throws RuntimeException{
        if(authenticationService.findByUsername(authUser.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(authenticationService.saveUser(authUser), HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody AuthUser user) {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<?> refreshToken(@RequestParam String token){
        return ResponseEntity.ok(jwtRefreshTokenService.generateAccessTokenFromRefreshToken(token));
    }

}
