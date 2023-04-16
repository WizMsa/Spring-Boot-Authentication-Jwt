package com.mnesa.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Service
public class JWTServices {

    private final static String SECRET_KEY = "4226452948404D635166546A576D5A7134743777217A25432A462D4A614E6452";
    public String extractUsername(String jwt_token) {
        return extractClaim(jwt_token,Claims::getSubject);
    }

    boolean isExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    boolean isTokenValid(String token, UserDetails userDetails){
        return (extractUsername(token).equals(userDetails.getUsername()) && !isExpired(token));
    }

   public String generateKey(UserDetails userDetails){
        return generateKey(new HashMap<>(),userDetails);
    }

    public String generateKey(Map<String, Objects> extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    public   <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        Claims claims = extractClaims(token);
       return claimResolver.apply(claims);
    }

    private Claims extractClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] byteKey = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(byteKey);
    }
}
