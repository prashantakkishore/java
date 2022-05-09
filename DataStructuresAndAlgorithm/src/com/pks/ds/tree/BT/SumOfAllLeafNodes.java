package com.pks.ds.tree.BT;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Do any traversal and sum to leaf nodes
 *  Do level order here
 * Input :
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 *                \
 *                 8
 *
 * Output: 24
 */
public class SumOfAllLeafNodes {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.left.right = new Node(8);
        printSum(head);
    }

    public static void printSum(Node head) {
        Queue<Node> queue = new LinkedList<>();
        int sum = 0;
        queue.add(head);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.print(node.data + " ");
            if (node.isLeaf()){
                sum = sum + node.data;
            }

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println();
        System.out.println("Sum " + sum);
    }


    static class Node{
        Node left;
        Node right;
        Integer data;
        public Node(Integer data) {
            this.data = data;
        }
        public boolean isLeaf() {
            return left == null && right == null;
        }

    }

}


