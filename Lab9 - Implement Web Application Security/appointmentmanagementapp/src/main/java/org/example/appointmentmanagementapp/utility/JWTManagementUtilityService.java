package org.example.appointmentmanagementapp.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTManagementUtilityService {
    private static final String SECRET="5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
    private Key getSignKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }
    public <T>T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims=extractAllClaims(token);
        return claimResolver.apply(claims);
    }
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }
    private String createToken(Map<String,Object> claims, String subject){
        var now= Instant.now();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(24, ChronoUnit.HOURS)))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
    public String generateToken(String username){
        Map<String,Object> claims=new HashMap<>();
        return createToken(claims,username);
    }
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username=extractUsername(token);
        return (username.equals(userDetails.getUsername()))&&!isTokenExpired(token);
    }
}
