package com.pks.ds.tree.BT;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Input :
 * 			    4
 * 			 /    \
 * 		   2	    7
 * 		 /   \    /   \
 * 	   1	  3	 6	   9
 *
 * Output : 
 * 
 * * 		    4
 * 			 /    \
 * 		   7	    2
 * 		 /   \    /   \
 * 	   9	  6	 3	   1
 *
 */

public class InvertBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(4, new Node(2, new Node(1, null, null), new Node(3, null, null)),
                new Node(7, new Node(6, null, null), new Node(9, null, null)));
        invertBfs(root);
        inOrder(root);
    }

    public static Node invertBfs(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            Node dummy = node.left;
            node.left = node.right;
            node.right = dummy;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static Node invertDfs(Node root) {
        if (root == null)
            return root;

        /* do the subtrees */
        Node left = invertDfs(root.left);
        Node right = invertDfs(root.right);

        /* swap the left and right pointers */
        root.left = right;
        root.right = left;

        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
}
