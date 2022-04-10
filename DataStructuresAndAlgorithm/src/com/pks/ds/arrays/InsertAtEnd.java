package com.pks.ds.arrays;

import java.util.Arrays;

public class InsertAtEnd {

    public static void main(String[] args) {
        int[] intArr = new int[6];
        for (int i = 0 ; i < 3; i++){
            intArr[i] = i;
        }

        System.out.println(intArr.length);
        Arrays.stream(intArr).forEach(System.out::println);
        intArr[3] = 10;
        Arrays.stream(intArr).forEach(System.out::println);
    }
}
