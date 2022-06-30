package com.pks.ds.recursion;

public class DecimalToBinary {

    public static void main(String[] args) {
        binary(233 , "" );
        System.out.println(binary(233 , "" ));
    }

    public static String binary(Integer num, String result) {
        if (num == 0)
            return result;

        int numDiv = (int) Math.floor(num / 2);
        int numReminder = num % 2;
        result = numReminder + result;
        return binary(numDiv, result);

    }
}
