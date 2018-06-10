package com.pks.ds.strings;

public class SubString {

	public static void main(String[] args) {
		
		String s = "AJAYkumarReddy";
		String sub = "kumar";
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == sub.charAt(count)) {
				count++;
			} else {
				count = 0;
			}
			if (count == sub.length()) {
				System.out.println("Sub String");
				return;
			}

		}

	}

}
