package com.java.misc.variables;

import java.math.BigDecimal;

public class Float {
	
	public static void main(String[] args) {
		
		BigDecimal number = new BigDecimal(123456789012345678.1234567890123456);
		System.out.println(number);
				
		float myNumber = 1234.567888F;
		System.out.println(myNumber);
		
		Double doub = 111222333444555.1234567890123456;
		System.out.println(doub);
		
		Double doub1 = (double) 123.12345678;
		System.out.println(doub1);
		
		Double doub12 =  123456789.88885d;
		System.out.println(doub12);
		
	}

}
