package com.pks.ds.strings.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 */
public class LongestSubstringNoDuplicates {

    public static void main(String[] args) {
        String str = "abbcbabcbb";
        System.out.println(longestSubstringNoDuplicates(str));
    }

    private static int longestSubstringNoDuplicates(String str) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end = 0;
        int total = 0;
        Set<Character> mapping = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!mapping.contains(arr[i])) {
                end++;
                mapping.add(arr[i]);
                total = Math.max(total, mapping.size());
            } else {
                mapping.remove(arr[start]);
                start++;
            }

        }

        return total;
    }
}
