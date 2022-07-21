package com.pks.ds.recursion;

/**
 * https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/
 */
public class PowerSetString {

    public static void main(String[] args) {
        String str = "abc";
        powerSet(str, 0, "");
    }

    private static void powerSet(String str, int i, String curr) {

        if (str.length()  == i) {
            System.out.println(curr);
            return;
        }
        // include char
        powerSet(str, i + 1, curr + str.charAt(i));
        // dont include char
        powerSet(str, i + 1, curr);
    }


}
