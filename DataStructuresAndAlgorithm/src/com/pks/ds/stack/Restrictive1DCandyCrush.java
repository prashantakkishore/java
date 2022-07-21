package com.pks.ds.stack;

import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=DOIIsJENf-0
 * Given string s choosing k group of same chars and remove them
 */
public class Restrictive1DCandyCrush {

    public static void main(String[] args) {
        String str = "geeksforgeegks";
        int k = 2;
        System.out.println(removeSameChars(str, k));
    }

    private static String removeSameChars(String str, int k) {

        if (str == null || str.length() == 0)
            return str;

        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

            if (!stack.empty() && stack.peek().character == str.charAt(i)) {
                if (stack.peek().occurrence == k - 1) {
                    stack.pop();
                } else {
                    stack.peek().occurrence++;
                }
            } else {
                Pair p = new Pair(str.charAt(i), 1);
                stack.push(p);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            while (pair.occurrence > 0) {
                sb.append(pair.character);
                pair.occurrence--;
            }
        }
        // Reverse as coming from Stack

        return sb.reverse().toString();


    }

    static class Pair {
        Character character;
        Integer occurrence;

        public Pair(Character c, Integer occurrence) {
            this.character = c;
            this.occurrence = occurrence;
        }
    }


}
