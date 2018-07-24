package com.pks.ds.strings.problems;

import java.util.HashMap;

public class AnagramWords {
	
	public static void main(String[] args) {
		
		System.out.println(areAnagrams("MotherinLaw", "HitlerWoman"));
		System.out.println(areAnagrams("keEp", "peeK"));
	}
	

	public static boolean areAnagrams(String one, String two) {
		if (one.length() == two.length()) {
			String s0 = one.toLowerCase();
			String s1 = two.toLowerCase();
			HashMap<Character, Integer> chars = new HashMap<Character, Integer>(
					one.length());
			Integer count;
			for (char c : s0.toCharArray()) {
				count = chars.get(c);
				count = Integer.valueOf(count != null ? count + 1 : 1);
				chars.put(c, count);
			}
			for (char c : s1.toCharArray()) {
				count = chars.get(c);
				if (count == null) {
					return false;
				} else {
					count--;
					chars.put(c, count);
				}
			}
			for (Integer i : chars.values()) {
				if (i != 0) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

}
