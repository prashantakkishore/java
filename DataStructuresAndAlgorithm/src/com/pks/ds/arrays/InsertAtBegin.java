package com.pks.ds.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertAtBegin {

    public static void main(String[] args) {
        int[] intArr = new int[6];
        for (int i = 0 ; i < 3; i++){
            intArr[i] = i + 5;
        }

        System.out.println(Arrays.toString(intArr));
        insertAtBegin(22, intArr);
    }

    private static void insertAtBegin (int num, int[] intArr){
        for (int i = 2; i >= 0 ; i--) {
            intArr[i+1] = intArr[i];
        }
        intArr[0] = num;
        System.out.println(Arrays.toString(intArr));
    }
}
