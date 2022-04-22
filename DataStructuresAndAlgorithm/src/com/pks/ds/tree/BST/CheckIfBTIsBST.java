package com.pks.ds.tree.BST;

import com.pks.ds.tree.TreeNode;
import com.pks.ds.tree.BT.traversal.InOrder;

public class CheckIfBTIsBST extends BSTBase {


	/**
	 * 	WRONG SOLUTION - will print true for below tree
	 * 			3
	 * 		   / \
	 * 		  2   5
	 * 		 /	\
	 * 		1	 4
	 *
	 */

	public static boolean check(TreeNode root) {
		if (root == null)
			return true;
		//TODO check root data with maxValue of left subtree
		if (root.getLeft() != null && root.getLeft().getData() > root.getData())
			return false;
		//TODO check root data with minValue of left subtree
		if (root.getRight() != null
				&& root.getRight().getData() < root.getData())
			return false;
		if (!check(root.getLeft()) || !check(root.getRight()))
			return false;

		return true;

	}

	public static boolean check_1(TreeNode node) {
		return check_2(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 *  CORRECT SOLUTION
	 *
	 */
	public static boolean check_2(TreeNode node, int min, int max) {
		/* an empty tree is BST */
		if (node == null)
			return true;

		/* false if this node violates the min/max constraints */
		if (node.getData() < min || node.getData() > max)
			return false;

		/*
		 * otherwise check the subtrees recursively tightening the min/max
		 * constraints
		 */
		// Allow only distinct values
		return (check_2(node.getLeft(), min, node.getData() - 1) && check_2(
				node.getRight(), node.getData() + 1, max));
	}

	public static void main(String[] args) {
		System.out.println(check(root));

		TreeNode root1 = new TreeNode(3);
		root1.setLeft(new TreeNode(2));
		root1.setRight(new TreeNode(5));
		root1.getLeft().setLeft(new TreeNode(1));
		root1.getLeft().setRight(new TreeNode(4));

		InOrder.recursive(root1);
		System.out.println(check(root1)); //wrong
		System.out.println(check_1(root1)); //correct
	}

}
