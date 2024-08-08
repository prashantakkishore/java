package com.pks.ds.tree.BST;

import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/description/
 * <p>
 * Solution:
 * Bruteforce -
 * Store val as in order and use as iterator.
 * ISSUE is it will take O(n) space.
 * <p>
 * To reduce, create, in order ,runtime as accessed, and store in a STACK.
 * <p>
 * 7
 * /    \
 * 3	    15
 * /    \
 * 9      20
 */
public class BSTIterator {

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15, t9, t20);
        TreeNode t7 = new TreeNode(7, t3, t15);

        BSTIterator iterator = new BSTIterator(t7);
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());


    }

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        fill(root);
    }

    public int next() {
        if (stack.isEmpty()) return -1;
        TreeNode node = stack.pop();
        fill(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void fill(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
