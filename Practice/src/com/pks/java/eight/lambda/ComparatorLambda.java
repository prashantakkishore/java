package com.pks.java.eight.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {

	public static void main(String[] args) {

		// This can be replaced with Lambda because this has only 1 abstract method
//		Comparator<String> comparator = new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return Integer.compare(o1.length(), o2.length());
//			}
//
//		};

		List<String> stars = Arrays.asList("*****", "***", "*", "****", "**");
		
		Comparator<String> comparatorLambda = (String o1, String o2) -> Integer.compare(o1.length(), o2.length());
		
		Collections.sort(stars, comparatorLambda);

		stars.forEach(System.out::println);

	}

}
