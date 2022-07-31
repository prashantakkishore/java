package com.pks.ds.arrays;

import java.util.Arrays;

public class InsertAtIndex {

    public static void main(String[] args) {
        int[] intArr = new int[6];
        for (int i = 0 ; i < 4; i++){
            intArr[i] = i + 11;
        }

        System.out.println(Arrays.toString(intArr));
        insertAtIndex(3, 20, intArr);
    }

    private static void insertAtIndex (int index, int num, int[] intArr){
        for (int i = intArr.length -2; i >= index ; i--) {
            intArr[i+1] = intArr[i];
        }
        intArr[index] = num;
        System.out.println(Arrays.toString(intArr));
    }
}
