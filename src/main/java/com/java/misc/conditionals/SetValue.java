package com.java.misc.conditionals;

public class SetValue {

	@SuppressWarnings("null")
	public static void main(String[] args) {

		String value = null;

		String result = "R";

		result = value.equals(null) ? "2" : "1";

		System.out.println(result);

	}

}
