package com.pks.ds.strings.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 *
 * Input: s = "aabcbcdbca", k = 2
 * Output: 4
 * Explanation: The substring is "bcbc" with length 4.
 */
public class LongestSubStringKDistinct {

    public static void main(String[] args) {
        String str = "aabcbcdbca";
        int distinctNum = 2;
        System.out.println(longestSubStringKDistinct(str, distinctNum));
    }

    private static int longestSubStringKDistinct(String str, int distinctNum) {

        int length = str.length();
        char[] chars = str.toCharArray();
        int start = 0;
        int end = 0;
        int totalMax = 0;
        Map<Character, Integer> mapping = new HashMap<>();
        for (int i = 0; i < length; i++) {
            mapping.put(chars[i], mapping.getOrDefault(chars[i], 0) + 1);

            if (mapping.size() <= distinctNum) {
                end++;
            } else {
                // remove from start until distinct reduces
                while (mapping.size() > distinctNum) {
                    int charOcc = mapping.get(chars[start]);
                    if (charOcc == 1) {
                        mapping.remove(chars[start]);
                    } else {
                        mapping.put(chars[start], --charOcc);
                    }
                    start++;
                }
            }
            // do +1 for start as its starting from 0
            totalMax = Math.max(totalMax, end - start +1 );
        }
        return totalMax;
    }
}
