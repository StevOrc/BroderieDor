package com.broderieDor.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.broderieDor.security.services.UserPrinciple;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

//Cette classe récupère le username de l'authentification de type Authentication, 
//ET  construit le token avec ce même username, Date() et secretKey (notre secrtet dans propoerties)
@Component
public class JwtProvider {
    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwtSecret}")
    private String jwtSecret;
 
    @Value("${jwtExpiration}")
    private int jwtExpiration;
    
    public String generateJwtToken(Authentication authentication) {
    	 
        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();
 
        // C'est ici que nous allons construire le Token grace à la méthode builder
        return Jwts.builder()
		                .setSubject((userPrincipal.getUsername())) // on set le subject, dans le Payload
		                .setIssuedAt(new Date()) // date début de l'IAT dans le PAYLOAD
		                .setExpiration(new Date((new Date()).getTime() + jwtExpiration*1000)) // date d'expiration
		                .signWith(SignatureAlgorithm.HS512, jwtSecret) // la signature dans le VERIFY SIGNATURE, l'encodage et le secret
		                .compact();
    }
    
    //Method qui va valider le token
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature -> Message: {} ", e);
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        }
        
        return false;
    }
    
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
			                .setSigningKey(jwtSecret)
			                .parseClaimsJws(token)
			                .getBody().getSubject();
    }
}
