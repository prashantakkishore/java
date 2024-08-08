package com.pks.ds.strings.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }
    public static  String minWindow(String s, String t) {
        List<Character> list = t.chars().mapToObj(c -> (char)c).toList();
        int minSize = Integer.MAX_VALUE;
        String minStr = "";
        for (int i = 1, j = 0; i < s.length(); i++) {
            List<Character> list2 = s.substring(j, i).chars().mapToObj(c -> (char)c).toList();
            if (list2.containsAll(list)){
                if(s.substring(j, i).length() <  minSize){
                    minStr = s.substring(j, i);
                    minSize = s.substring(j, i).length();
                    j = i;
                }

            }
        }

        return minStr;
    }
}
