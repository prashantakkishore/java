package com.pks.ds.recursion;

public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(palindrome("kayak"   ));
    }

    public static boolean palindrome(String str) {
        if(str.length() == 1)
            return true;

        // check first and last chars
        if (str.charAt(0 ) == str.charAt(str.length() -1)) {
            // send string by removing first and last chars
            return palindrome(str.substring(1, str.length() -1));
        }

        return false;

    }
}
