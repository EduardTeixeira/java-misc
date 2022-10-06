package com.java.misc.math;

public class BigDecimal {

	public static void main(String[] args) {

		java.math.BigDecimal numero = new java.math.BigDecimal(5);

		// (new java.math.BigDecimal(10));
		// numero = numero.add(new java.math.BigDecimal(10));

		numero.add(new java.math.BigDecimal(10));

		System.out.println(numero);

		java.math.BigDecimal counter = new java.math.BigDecimal(10001);

		if (counter.compareTo(new java.math.BigDecimal(10000)) == 1) {
			System.out.println("maior que 10 mil");
		} else if (counter.compareTo(new java.math.BigDecimal(5000)) == 1) {
			System.out.println("maior que 5 mil");
		} else if (counter.compareTo(new java.math.BigDecimal(1000)) == 1) {
			System.out.println("maior que 1 mil");
		} else if (counter.compareTo(new java.math.BigDecimal(500)) == 1) {
			System.out.println("maior que 500");
		} else {
			System.out.println("menor que 500");
		}

		java.math.BigDecimal testeNull = new java.math.BigDecimal(0);

		if (numero == null) {
			System.out.println("IFIFIF");
		}

		System.out.println(numero != null ? 0 : 1);

	}

}
