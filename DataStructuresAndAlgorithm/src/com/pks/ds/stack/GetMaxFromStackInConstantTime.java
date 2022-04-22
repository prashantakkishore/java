package com.pks.ds.stack;

import java.util.Stack;

/**
 * Input : 4 19 7 14 20
 * Output : Max Values in stack are
 *          4 19 19 19 20
 *
 * Input : 40 19 7 14 20 5
 * Output :  Max Values in stack are
 *          40 40 40 40 40 40
 */
public class GetMaxFromStackInConstantTime {

    public static void main(String[] args) {
        GetMaxFromStackInConstantTime1 stack = new GetMaxFromStackInConstantTime1();
        stack.push(20);
        stack.push(19);
        stack.pop();
        stack.push(7);
        System.out.println(stack.getMax());
        stack.push(14);
        stack.push(20);
        System.out.println(stack.getMax());
    }

    static class GetMaxFromStackInConstantTime1 {
        static Stack<Integer> mainStack = new Stack<>();
        static Stack<Integer> maxStack = new Stack<>(); // to track max anytime


        public static void push(Integer num) {
            mainStack.push(num);
            if (maxStack.isEmpty() || maxStack.peek() < num){
                maxStack.push(num);
            }
        }

        public static Integer pop() {
            Integer num = mainStack.pop();
            if (!maxStack.isEmpty() && maxStack.peek() == num){
                maxStack.pop();
            }
            return num;
        }

        public static Integer getMax() {
            Integer num = maxStack.peek();
            return num;
        }
    }
}

