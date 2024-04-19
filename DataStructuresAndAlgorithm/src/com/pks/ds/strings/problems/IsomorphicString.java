package com.pks.ds.strings.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Input:  str1 = "aab", str2 = "xxy"
 * Output: True
 * 'a' is mapped to 'x' and 'b' is mapped to 'y'.
 */

public class IsomorphicString {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("aab", "xxxy"));
    }

    // O(n)
    public static boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        Map<Character, Character> mapping = new HashMap();
        for (int i = 0; i < str1.length(); i++) {
            if (!mapping.containsKey(str1.charAt(i))) {
                mapping.put(str1.charAt(i), str2.charAt(i));
            } else {
                Character c = mapping.get(str1.charAt(i));
                if (!c.equals(str2.charAt(i)))
                    return false;
            }
        }
        return true;
    }


}
