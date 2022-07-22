package com.java.misc.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComparingDates {

	public static void main(String[] args) throws ParseException {

		String hoje = "25/06/2022";
		String depois = "25/07/2022";

		boolean rDate;

		rDate = initialDateMustBeLess(hoje, depois);
		System.out.println("Resultado 1 >>>> " + rDate);

		rDate = initialDateMustBeLess(hoje, "");
		System.out.println("Resultado 2 >>>> " + rDate);

		rDate = initialDateMustBeLess("", "");
		System.out.println("Resultado 3 >>>> " + rDate);

		rDate = initialDateMustBeLess("14/06/2022", "14/06/2022");
		System.out.println("Resultado 4 >>>> " + rDate);

		rDate = initialDateMustBeLess("14/06/2022", "13/06/2022");
		System.out.println("Resultado 5 >>>> " + rDate);

		rDate = initialDateMustBeLess("14/06/2022", "15/06/2022");
		System.out.println("Resultado 6 >>>> " + rDate);

	}

	public static boolean initialDateMustBeLess(String initialDate, String finalDate) throws ParseException {

		if ((initialDate.equals("") || initialDate == null) && (finalDate.equals("") || finalDate == null)) {
			return false;
		}

		if (finalDate.equals("") || finalDate == null) {
			return false;
		}

		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

		Date firstDate = fmt.parse(initialDate);

		Date secondDate = fmt.parse(finalDate);

		if (firstDate.getTime() > secondDate.getTime()) {
			return true;
		}

		return false;

	}

}
