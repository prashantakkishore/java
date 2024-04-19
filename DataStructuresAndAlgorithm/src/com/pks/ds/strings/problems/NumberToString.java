package com.pks.ds.strings.problems;

public class NumberToString {

    public static void main(String[] args) {
        System.out.println("Number in String: " + toString(11876));
    }

    public static String toString(Integer num) {

        StringBuffer resultString = new StringBuffer();
        int numAbs = 0;
        numAbs = num < 0 ? Math.abs(num) : num;
        while (numAbs > 0) {
            int quotient = numAbs / 10;
            int reminder = numAbs % 10;
            numAbs = quotient;
            resultString.append(reminder + "");
        }
        if (num < 0) {
            resultString.append("-");
        }
        return resultString.reverse().toString();
    }
}
