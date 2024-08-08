package com.pks.ds.strings.problems;

/**
 * https://leetcode.com/problems/one-edit-distance/description/
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "", t = ""
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 */
public class OneEditDistance {
    public static void main(String[] args) {
        System.out.println(isOneEditDistance("ab", "acb"));
        System.out.println(isOneEditDistance("axdb", "acb"));
        System.out.println(isOneEditDistance("ab", "acb"));
        System.out.println(isOneEditDistance("a", ""));
    }

    public static boolean isOneEditDistance(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        if (l1 < l2)
            isOneEditDistance(t, s);
        if (Math.abs(l1 - l2) > 1 || (l1 == 0 && l2 == 0))
            return false;
        int differnce = 0;
        for (int i = 0, j = 0; i < l1; i++) {
            if (l2 > 0 && s.charAt(i) == t.charAt(j))
                j++;
            else if (l2 > 0 && s.charAt(i) != t.charAt(j))
                differnce++;
        }
        return differnce > 1 ? false : true;
    }
}
