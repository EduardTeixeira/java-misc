package com.java.misc.jwt;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.java.misc.models.Pessoa;

public class JwtFlow {

	private static final String SECRET = "QeThWmZq4t7w!z%C*F-JaNdRgUkXn2r5";
	private static final String SECRET2 = "UkXp2s5v8y/B?E(H+MbQeShVmYq3t6w9";

	// private static final String TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJFZHVhcmQiLCJpc3MiOiJsb2NhbGhvc3Q6ODI4NCIsImV4cCI6MTY2NTE2OTcwNywiaWF0IjoxNjY1MTY4ODA3fQ.GbfnPg5sb4ngGkfIIQmEOH3XhZi1Z23uhdzQnz9Qw1E";

	public static void main(String[] args) {

		Pessoa pessoa = new Pessoa("Eduard", "Teixeira", 26);

		String token = creator(pessoa);

		verifier(token);

		notVerify(token);

	}

	public static String creator(Pessoa pessoa) {

		try {

			System.out.println("CREATOR...");

			Algorithm algorithm = Algorithm.HMAC256(SECRET);

			String token = JWT.create().withIssuer("auth012").sign(algorithm);

			System.out.println("TOKEN ::: " + token);

			String token2 = JWT.create()
					.withClaim("name", 123)
					.withArrayClaim("array", new Integer[] { 1, 2, 3 })
					.withNullClaim("claim_name")
					.sign(algorithm);

			System.out.println("TOKEN-2 ::: " + token2);
			
			String token3 = JWT.create()
					.withSubject(pessoa.getNome())
					.withIssuer("localhost:8284")
					.withIssuedAt(new Date())
					.withExpiresAt(
							Date.from(
									LocalDateTime
										.now()
										.plusMinutes(15L)
										.atZone(ZoneId.systemDefault())
										.toInstant()
									)
							)
					.sign(algorithm);
			
			System.out.println("TOKEN-3 ::: " + token3);
			
			return token3;

		} catch (JWTCreationException e) {

			e.printStackTrace();
			
			return null;

		} catch (Exception e) {

			e.printStackTrace();
			
			return null;

		}

	}

	public static void verifier(String token) {

		try {

			System.out.println("\nVERIFIER...");

			Algorithm algorithm = Algorithm.HMAC256(SECRET); // use more secure key

			// Reusable verifier instance
			com.auth0.jwt.JWTVerifier verifier = JWT.require(algorithm)
					.withIssuer("localhost:8284")
					.build();

			DecodedJWT jwt = verifier.verify(token);

			System.out.println(jwt);
			System.out.println(jwt.getAlgorithm());
			System.out.println(jwt.getSubject());
			System.out.println(jwt.getIssuer());
			System.out.println(jwt.getExpiresAt());
			System.out.println(jwt.getIssuedAt());

		} catch (JWTVerificationException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void notVerify(String token) {

		try {

			System.out.println("\nNOT VERIFY...");

			DecodedJWT jwt = JWT.decode(token);

			System.out.println(jwt);

		} catch (JWTDecodeException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
