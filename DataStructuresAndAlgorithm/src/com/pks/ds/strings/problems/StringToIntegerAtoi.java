package com.pks.ds.strings.problems;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * <p>
 * Example 1:
 * Input: s = "42"
 * Output: 42
 * <p>
 * Example 2:
 * Input: s = " -042"
 * Output: -42
 */
public class StringToIntegerAtoi {
    public static void main(String[] args) {
        //System.out.println(Integer.MAX_VALUE); // 2147483647
        //System.out.println(Integer.MIN_VALUE); // -2147483648
        System.out.println(myAtoi("2147483648")); // Greater than int MAX should return 2147483647
        System.out.println(myAtoi("42")); // 42
        System.out.println(myAtoi("  -42")); // -42
        System.out.println(myAtoi("1337c0d3")); // 1337
        System.out.println(myAtoi("0-1")); // 0
        System.out.println(myAtoi("words and 987")); // 0
    }

    public static int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        while (i < s.length() && s.charAt(i) == ' ')
            i++;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int result = 0;
        while (i < s.length() && s.charAt(i) > '0' && s.charAt(i) < '9') {
            // 1 - Now every time we multiply result with 10 so If previously result is > Integer.MAX_VALUE / 10
            // We will end up in overflow/underflow.
            // 2 - If result is already equal to Integer not considering last number which is 7 . Eg: Integer MAX is 2147483647
            // So if number is 214748364 already we can only take 7 as last number.
            if (result > Integer.MAX_VALUE / 10 /* This is 214748364 */ ||
                    (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10 /* This is 7 */))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            int num = s.charAt(i) - '0';
            // Basic logic.
            result = result * 10 + num;
            i++;
        }
        return result * sign;
    }
}
