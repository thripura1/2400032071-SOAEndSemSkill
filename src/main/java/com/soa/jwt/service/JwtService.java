
package com.soa.jwt.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;
import javax.crypto.SecretKey;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String username, String role) {

        SecretKey key = Keys.hmacShaKeyFor(
            Decoders.BASE64.decode(secret));

        long time = System.currentTimeMillis();

        return Jwts.builder()
                .subject(username)
                .claim("role", role)
                .issuedAt(new Date(time))
                .expiration(new Date(time + 3600000))
                .signWith(key)
                .compact();
    }
}
