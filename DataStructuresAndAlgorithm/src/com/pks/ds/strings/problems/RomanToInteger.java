package com.pks.ds.strings.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 *
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("IL"));
        System.out.println(romanToInt("MCMXCIV"));

        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanDict = new HashMap<>();
        romanDict.put('I', 1);
        romanDict.put('V', 5);
        romanDict.put('X', 10);
        romanDict.put('L', 50);
        romanDict.put('C', 100);
        romanDict.put('D', 500);
        romanDict.put('M', 1000);
        int i = 0;
        int j = 1;
        int result = 0;
        while (j < s.length()) {
            if (romanDict.get(s.charAt(j)) > romanDict.get(s.charAt(i))) {
                result = result + romanDict.get(s.charAt(j)) - romanDict.get(s.charAt(i));
                i = j + 1;
                j = j + 2;
            } else {
                result = result + romanDict.get(s.charAt(i++));
                j++;
                if (i == s.length() - 1)
                    result = result + romanDict.get(s.charAt(i));
            }
        }
        return result;
    }
}
