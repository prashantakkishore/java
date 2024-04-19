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
        String str = "pwwkew";
        System.out.println(longestSubstringNoDuplicates_Practice(str));
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

    private static int longestSubstringNoDuplicates_Practice(String str){

        Set<Character> set = new HashSet<>();
        int start = 0;
        int longest = 0;
        while(start < str.length()){
            if(set.contains(str.charAt(start))){
                set.clear();
            } else {
                set.add(str.charAt(start));
                longest = Math.max(set.size(), longest);

            }
            start++;
        }

        return longest;
    }
}
