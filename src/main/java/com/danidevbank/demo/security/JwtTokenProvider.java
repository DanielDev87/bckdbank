package com.danidevbank.demo.security;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.danidevbank.demo.config.JwtProperties;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtProperties.getExpirationMs());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtProperties.getSecret()));
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}