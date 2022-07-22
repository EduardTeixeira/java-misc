package com.java.misc.conditionals;

import com.java.misc.models.ClasseTeste;

public class IfTernario {

	public static void main(String[] args) {

		ClasseTeste classe = new ClasseTeste();

		classe.setName("A");

		System.out.println(classe.getName() == null || classe.getName().equals("null") ? "a" : "b");

		System.out.println(classe.getOutraClasse() == null || classe.getOutraClasse().getId() == null ? 1 : 2);

	}

}
