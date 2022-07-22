package com.java.misc.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

public class JWTCreator {

	private static final String SECRET = "QeThWmZq4t7w!z%C*F-JaNdRgUkXn2r5";

	public static void main(String[] args) {

		creator();

	}

	public static void creator() {

		try {

			Algorithm algorithm = Algorithm.HMAC256(SECRET);

			String token = JWT.create().withIssuer("auth0").sign(algorithm);

			System.out.println("TOKEN ::: " + token);

			String token2 = JWT.create().withClaim("name", 123).withArrayClaim("array", new Integer[] { 1, 2, 3 })
					.withNullClaim("claim_name").sign(algorithm);

			System.out.println("TOKEN-2 ::: " + token2);

		} catch (JWTCreationException exception) {

			System.out.println(exception);

		}

	}

}
