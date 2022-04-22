package com.pks.ds.queue;

import java.util.Stack;

/**
 * Queue using 2 stacks is simple
 * 1 - Enqueue - push stack1
 * 2 - Dequeue - pop and push to stack2 until last element dont push last, puh stack2 to stack1
 *
 * @author Prashantak
 */

public class QueueUsing2Stacks {

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }

    //More efficiant
    static class Queue {
        static Stack<Integer> stack1;
        static Stack<Integer> stack2;


        /* Function to push an item to stack*/
        static void push(Stack<Integer> top_ref, int new_data) {
            // Push the data onto the stack
            top_ref.push(new_data);
        }

        /* Function to pop an item from stack*/
        static int pop(Stack<Integer> top_ref) {
            /*If stack is empty then error */
            if (top_ref.isEmpty()) {
                System.out.println("Stack Underflow");
                System.exit(0);
            }

            // pop the data from the stack
            return top_ref.pop();
        }

        // Function to enqueue an item to the queue
        static void enQueue(int x) {
            stack1.push(x);
        }

        /* Function to deQueue an item from queue */
        static int deQueue() {
            int x;

            /* If both stacks are empty then error */
            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.out.println("Q is empty");
                System.exit(0);
            }

        /* Move elements from stack1 to stack 2 only if
        stack2 is empty */
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    x = pop(stack1);
                    push(stack2, x);
                }
            }
            x = pop(stack2);
            return x;
        }
    }

    // Empies stack twice
    static class Queue1 {
        static Stack<Integer> s1 = new Stack<Integer>();
        static Stack<Integer> s2 = new Stack<Integer>();

        static void enQueue(int x) {
            // Move all elements from s1 to s2
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
                //s1.pop();
            }

            // Push item into s1
            s1.push(x);

            // Push everything back to s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
                //s2.pop();
            }
        }

        // Dequeue an item from the queue
        static int deQueue() {
            // if first stack is empty
            if (s1.isEmpty()) {
                System.out.println("Q is Empty");
                System.exit(0);
            }

            // Return top of s1
            int x = s1.peek();
            s1.pop();
            return x;
        }
    }

    ;
}
