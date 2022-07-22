package com.java.misc.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTVerifier {
	
	private static final String SECRET = "QeThWmZq4t7w!z%C*F-JaNdRgUkXn2r5";
	
	private static final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhcnJheSI6WzEsMiwzXSwibmFtZSI6MTIzLCJjbGFpbV9uYW1lIjpudWxsfQ.IvKANCT3B6LxntlsKHFIg7TvM6CDVB-eMAlQZH2Zhqk";

	public static void main(String[] args) {

		verifier();
		
		notVerify();

	}

	public static void verifier() {

		try {

			Algorithm algorithm = Algorithm.HMAC256(SECRET); // use more secure key

			com.auth0.jwt.JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0").build(); // Reusable verifier instance

			DecodedJWT jwt = verifier.verify(token);
			
			System.out.println(jwt);

		} catch (JWTVerificationException exception) {

			System.out.println(exception);

		}

	}
	
	public static void notVerify() {
		
		try {
			
		    DecodedJWT jwt = JWT.decode(token);
		    
		    System.out.println(jwt);
		    
		} catch (JWTDecodeException exception){
			
			System.out.println(exception);
			
		}		
	
	}

}
