package com.pks.ds.strings.problems;

import java.util.HashMap;
import java.util.Map;

public class NumberToHexaDecimalString {

    public static void main(String[] args) {
        System.out.println("Number in Hexa String: " + toHexaString(-1)); // doesnt work for negative values
        System.out.println(Integer.toHexString(-1));
    }

    public static String toHexaString(Integer num) {

        StringBuffer resultString = new StringBuffer();
        final String digits = "0123456789ABCDEF";

        num = num < 0 ? (int) Math.pow(2, 32) + num : num; // for negative number add num to 2^32
        while (num > 0) {
            int reminder = num % 16;
            num = num / 16;
            String reminderString = digits.charAt(reminder) + "";
            resultString.append(reminderString);
        }
        return resultString.reverse().toString();
    }

}
