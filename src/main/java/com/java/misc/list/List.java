package com.java.misc.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class List {

	public static void main(String[] args) {

		//
		long starttime = System.currentTimeMillis();
		java.util.List<Integer> l1 = new ArrayList<Integer>();
		for (int i = 1; i <= 10000000; i++) {
			l1.add(i);
		}
		System.out.println(l1.size());

		long endtime = System.currentTimeMillis();

		System.out.println(endtime - starttime);

		//
		long starttime1 = System.currentTimeMillis();
		java.util.List<Integer> l2 = new LinkedList<Integer>();
		for (int i = 1; i <= 10000000; i++) {
			l2.add(i);
			// l1.add(i);
		}
		System.out.println(l2.size());

		long endtime1 = System.currentTimeMillis();

		System.out.println(endtime1 - starttime1);

		System.out.println("tam 1 " + l1.size());
		
		// l1 = new ArrayList<Integer>();
		
		l1.clear();
		
		System.out.println("tam 1 " + l1.size());
		
	}

}
