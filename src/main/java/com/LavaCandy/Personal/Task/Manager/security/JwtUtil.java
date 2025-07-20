package com.LavaCandy.Personal.Task.Manager.security;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import io.jsonwebtoken.Jwts;

public class JwtUtil {

    private final String SECRET_KEY = "mysupersecretkey12345678901234567890"; // must be at least 32 characters
    private final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds

    private SecretKey getSecretKey() {
        return new SecretKeySpec(SECRET_KEY.getBytes(), "HmacSHA256");
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSecretKey())
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
