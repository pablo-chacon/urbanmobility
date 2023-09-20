package com.example.maasfp.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;


public class JwtUtils {
    private final String SECRET_KEY = "your-secret-key";
    private final long EXPIRATION_TIME = 86400000; // 24 hours

    /**
     * @param accountType provider, admin, user.
     * @param userId      user ID.
     * @return JWT token.
     */
    public String generateToken(String accountType, String userId) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(accountType)
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /**
     * @param "Jwt-token".
     * @return type, ID and validity.
     * @throws JwtValidationException if the token is invalid or has expired.
     */
    public  Claims validateToken(String token) throws JwtValidationException {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new JwtValidationException("Invalid or expired token.");
        }
    }
}



