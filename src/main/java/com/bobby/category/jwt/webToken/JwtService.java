package com.bobby.category.jwt.webToken;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	public static final String SECRET= "31A7E1EAF0DE5ECF3A3F9C2F8C00A6DA154D2F54B1CC189338B0B697BB06875E40788F7F05E87066F0D5B4235A045F0CC6A0C33C1543C0BB5DE2479C277A7F85";
    public static final long VALIDITY= TimeUnit.HOURS.toMillis(30);
	
    
   
	
	public String generateToken(UserDetails userDetails) {
		Map<String,String> claims= new  HashMap<>();
		claims.put("bob", "Bobby");
		
		return Jwts.builder()
		       .claims(claims)
		       .subject(userDetails.getUsername())
		       .issuedAt(Date.from(Instant.now()))
		       .expiration(Date.from(Instant.now().plusMillis(VALIDITY)))
		       .signWith(generateKey())
		       .compact();
	}
	
	private SecretKey generateKey() {
		byte[] decodedKey = Base64.getDecoder().decode(SECRET);
		return Keys.hmacShaKeyFor(decodedKey);
	}
	
	public String extractUsername(String jwt) {
		Claims claims = getClaims(jwt);
		return claims.getSubject();
	}
		
	
	public Claims getClaims(String jwt) {
		
		return Jwts.parser()
		        .verifyWith(generateKey())
		        .build()
		        .parseSignedClaims(jwt)
		        .getPayload();
		
		
		
	}
	
	public boolean isTokenValid(String jwt) {
		Claims claims = getClaims(jwt);
		return claims.getExpiration().after(Date.from(Instant.now()));
		
	}
	
}
