package com.example.demo3.controller;

import com.example.demo3.dto.AutheticationRequest;
import com.example.demo3.dto.AutheticationResponce;
import com.example.demo3.dto.RefreshTokenRequest;
import com.example.demo3.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AutheticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.username(), authenticationRequest.password())
            );
            UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.username());
            String accessToken = jwtUtil.generateAccessToken(userDetails);
            String refreshToken = jwtUtil.generateRefreshToken(userDetails);
            return ResponseEntity.ok(new AutheticationResponce(accessToken, refreshToken));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
        }
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        String refreshToken = refreshTokenRequest.refreshToken();
        String username = jwtUtil.extractUsername(refreshToken);

        if (username != null && jwtUtil.validateToken(refreshToken, userDetailsService.loadUserByUsername(username))) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            String newAccessToken = jwtUtil.generateAccessToken(userDetails);

            return ResponseEntity.ok(new AutheticationResponce(newAccessToken, refreshToken));
        } else {
            throw new RuntimeException("Invalid refresh token");
        }
    }
}
