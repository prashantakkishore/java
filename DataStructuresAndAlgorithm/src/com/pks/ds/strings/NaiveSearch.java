package com.pks.ds.strings;

/**
 * Time Complexity  : O((n - m -1 ) * m) ~ O(n * M)
 * Space Complexity : O(1)
 *
 */
public class NaiveSearch {

	public static void search(String pattern, String text) {

		for (int i = 0; i < (pattern.length() - text.length()); i++) {
			int match = 0;
			while (match < text.length()) {
				if (pattern.charAt(i + match) == text.charAt(match))
					match++;
				else
					break;

			}
			if (match == (text.length()))
				System.out.println("Match at index : " + i);
		}

	}

	public static void main(String[] args) {
		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
		search(txt, pat);
	}
}
