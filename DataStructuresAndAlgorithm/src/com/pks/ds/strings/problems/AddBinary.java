package com.pks.ds.strings.problems;

/**
 * https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/263/
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int iVal = i >= 0 ? a.charAt(i--) - '0' : 0;
            int jVal = j >= 0 ? a.charAt(j--) - '0' : 0;
            int sum = carry + iVal + jVal;
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();
    }
}
