package com.codehive.restaurantsservice.auth.infrastructure.utils;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class JWTUtils {

    @Value("${JWT_SECRET}")
    private String jwtSecret;



    public  Boolean isValidateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(jwtSecret.getBytes()).build().parseClaimsJws(token);
            return Boolean.TRUE;
        }catch (Exception exception){
            return false;
        }
    }
    public Claims getClaimsFromJWT(String jwt) {
        return Jwts.parserBuilder().setSigningKey(jwtSecret.getBytes()).build().parseClaimsJws(jwt).getBody();
    }


    public String getJWTFromString(String bearerToken) {
        String bearerStart = "Bearer ";

        if (!StringUtils.hasText(bearerToken) || !bearerToken.startsWith(bearerStart)) {
            return null;
        }
        return bearerToken.substring(bearerStart.length());
    }
}


