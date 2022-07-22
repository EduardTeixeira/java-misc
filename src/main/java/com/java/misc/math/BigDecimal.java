package com.java.misc.math;

public class BigDecimal {

	public static void main(String[] args) {

		java.math.BigDecimal numero = new java.math.BigDecimal(5);

		// (new java.math.BigDecimal(10));
		// numero = numero.add(new java.math.BigDecimal(10));

		numero.add(new java.math.BigDecimal(10));

		System.out.println(numero);

	}

}
