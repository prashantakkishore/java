package com.pks.ds.strings.problems;

public class StringCompression {

    public static void main(String[] args) {
        char[] input = new char[]{'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'c', 'a', 'a', 'a', 'd', 'd', 'e'};
        char[] compressed = compress(input);
        System.out.println(compressed);
    }


    public static char[] compress(char[] input) {
        int index = 0;
        int i = 0;
        while (i < input.length) {
            int j = i;
            while (j < input.length && input[i] == input[j]) {
                j++;
            }
            input[index++] = input[i];
            if (j - i > 1) {
                String count = j - i + "";
                for (char c : count.toCharArray()) {
                    input[index++] = c;
                }
            }
            i = j;
        }

        return input;
    }
}
