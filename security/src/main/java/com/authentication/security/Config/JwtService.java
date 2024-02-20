package com.authentication.security.Config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class JwtService {
    public static  String SECRET_KEY = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEA0eZekL5vIkbUiB4DeCLhiqC1mG5uOfLU/IPno3SfuLQmsIMGcLYQVjSl7QKKufeMxMhtLwe7dIj6S9yoYlX89QIDAQABAkEArjLYTJwfM31BKW5vRqb8M8bIrycHB8TGioMWHQvO+sPXh4e0vusaIj3VJgIwr/U65G3riifsetENSm5qa7YHyQIhAOof9n64K9zlg6mek/GBm386zlcHGeJP/fvWlHfq5mhfAiEA5YL4B+4CW/foLgUQ/Mk2/1OBsCamwSdXSP8idL31qysCIH/RMV5fJ7syJh49L+Gic4UTUsEaZFw0daG+tVF+kYmbAiAg/Ei/gwKNyzxwWMQPQLAJ1CugcH2o5wmRcTG3i5GiTwIhAKJ9x+A+2Fw2ycyF/QO8PjKortNTlZY7jNJvfvQw0RF7";
    public String extractUsername(String jwt) {
        return extractClaim(jwt,Claims::getSubject);
    }
    private Claims extractAllClaims(String jwt)
    {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }
    public <T> T extractClaim(String jwt, Function<Claims,T> claimsResolver)
    {
        final Claims claims = extractAllClaims(jwt);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userdetails)
    {
        return this.generateToken(new HashMap<>(),userdetails);
    }
    public  String generateToken(Map<String, Objects> extraClaims , UserDetails userdetails)
    {
        long expirationTimeMillis = System.currentTimeMillis() + (1000 * 60 * 24);
        return  Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userdetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(expirationTimeMillis))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }
    public Boolean isTokenValid(String jwt, UserDetails userdetails)
    {
        final String email = extractUsername(jwt);
        return (email.equals(userdetails.getUsername()) && !isTokenExpired(jwt));
    }

    private boolean isTokenExpired(String jwt) {
        return  extractExpiration(jwt).before(new Date());
    }

    private Date extractExpiration(String jwt) {
        return  extractClaim(jwt,Claims::getExpiration);
    }
}
