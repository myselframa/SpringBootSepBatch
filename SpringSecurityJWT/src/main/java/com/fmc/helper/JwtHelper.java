package com.fmc.helper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtHelper {
	
	@Value("${app.secret}")
	private String secret;
	
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}
	
	public String generatToken(String subject) {
		Map<String,Object> claims=new HashMap<>();
		return generateTocken(claims,subject);
	}
	
	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
	}
	
	private String generateTocken(Map<String,Object> claims,String subject) {
		return Jwts.builder().setClaims(claims)
				.setSubject(subject)
				.setIssuer("SAMPLE TEST")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(10)))
				.signWith(SignatureAlgorithm.HS256, secret.getBytes())
				.compact();
	}
}
