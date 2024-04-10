package com.pks.ds.stack;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(valiadParenteses("{[]"));
    }


    public static boolean valiadParenteses(String str){
        Stack<Character> stack = new Stack<>();
        for (char character : str.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            }
            if (character == ')' && stack.peek() == '(' && !stack.isEmpty()) {
                stack.pop();
            }
            if (character == ']' && stack.peek() == '[' && !stack.isEmpty()) {
                stack.pop();
            }
            if (character == '}' && stack.peek() == '{' && !stack.isEmpty()) {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
