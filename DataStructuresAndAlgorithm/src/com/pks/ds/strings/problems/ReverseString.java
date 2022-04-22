package com.pks.ds.strings.problems;

public class ReverseString {

    public static void main(String[] args) {
        char[] str = "Prashantak".toCharArray();
        int start = 0;
        int end = str.length -1;
        while(start < end){
            char c = str[start];
            str[start ] = str[end];
            str[end] = c;
            start++;
            end--;
        }

        System.out.println(String.valueOf(str));

    }
}
