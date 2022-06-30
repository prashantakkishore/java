package com.pks.ds.recursion;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverse("prashantak"   ));
    }

    public static String reverse(String str) {

        if (str.length() == 1)
            return str;

        return reverse(str.substring(1)) + str.charAt(0);

    }


}
