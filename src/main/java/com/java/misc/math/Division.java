package com.java.misc.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Division {

	public static void main(String[] args) {

		int rows = 700;

		int row = 100;

		int result = rows / row;

		System.out.println(result);

		int modResult = rows % row;

		System.out.println(modResult);

		if ((rows % row) > 0) {
			result++;
			System.out.println(result);
		}

		System.out.println("\nCONTADORES...");
		BigDecimal counter = new BigDecimal(750);
		int result1 = counter.divide(new BigDecimal(row), RoundingMode.FLOOR).intValue();
		// BigDecimal result1 = counter.divide(new BigDecimal(row));
		System.out.println(result1);

		BigDecimal modBig = counter.remainder(new BigDecimal(row));
		System.out.println(modBig);

		if (counter.remainder(new BigDecimal(row)).compareTo(BigDecimal.ZERO) == 1) {
			System.out.println("sdddd");
			result1++;
		}

		System.out.println("\nCONTADOR...: " + result1);
		
		for (int i = 0; i < result1; i++) {
			System.out.println("Value...:"+i);
		}

	}

}
