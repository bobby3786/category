package com.bobby.category;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;

import javax.crypto.SecretKey;

public class JwtSecretMaker {
	
	@Test
	public void generateSecreteKey() {
		
		SecretKey key = Jwts.SIG.HS512.key().build();
		
		String encodedkey = DatatypeConverter.printHexBinary(key.getEncoded());
		System.out.printf("\nKey = [%s]\n",encodedkey);
	}

}
