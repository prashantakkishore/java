package com.pks.ds.tree.BT;

import java.util.LinkedList;
import java.util.Queue;

import com.pks.ds.tree.TreeBase;
import com.pks.ds.tree.TreeNode;

/**
 * 
 * Input : 
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 * 
 * Output : 7
 * 
 */
public class MaxInBT extends TreeBase {

	public static int recursion(TreeNode root) {

		int maxValue;
		if (root == null) {
			maxValue = Integer.MIN_VALUE;
		} else {
			int leftMax = recursion(root.getLeft());
			int rightMax = recursion(root.getRight());
			if (leftMax > rightMax) {
				maxValue = leftMax;
			} else {
				maxValue = rightMax;
			}

			if (root.getData() > maxValue)
				maxValue = root.getData();
		}
		return maxValue;

	}
	
	public static int iterative(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int maxValue = Integer.MIN_VALUE;

		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			maxValue = currentNode.getData() > maxValue ? currentNode.getData() : maxValue;
			if (currentNode.getLeft() != null) {
				queue.offer(currentNode.getLeft());
			}
			if (currentNode.getRight() != null) {
				queue.offer(currentNode.getRight() );
			}
		}
		return maxValue;
	}

	public static void main(String[] args) {
		System.out.println(recursion(root));
		System.out.println(iterative(root));
	}

}
