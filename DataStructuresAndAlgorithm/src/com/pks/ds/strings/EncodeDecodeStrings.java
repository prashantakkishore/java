package com.pks.ds.strings;

public class EncodeDecodeStrings {

    public static void main(String[] args) {
        // encode with non-ascii char. ASCII range is 0-128
        char c = (char)200;
        String s = "hello" + c + "world";
        System.out.println(c);
        System.out.println(s);
        // decode
        String[] strs = s.split(String.valueOf(c));
        System.out.println(strs[0] + " " + strs[1]);
    }
}
