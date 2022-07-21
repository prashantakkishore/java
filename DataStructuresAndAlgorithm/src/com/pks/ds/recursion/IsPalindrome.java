package com.pks.ds.recursion;

public class IsPalindrome {

    public static void main(String[] args) {

        System.out.println(palindromeNoSubstring("kayak1"   , 0 , "kayak1".length() - 1));
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

    public static boolean palindromeNoSubstring(String str, int l, int r) {
        if (l >= r)
            return true;

        if (str.charAt(l) != str.charAt(r))
            return false;

        return palindromeNoSubstring(str, l + 1, r -1);


    }

}
