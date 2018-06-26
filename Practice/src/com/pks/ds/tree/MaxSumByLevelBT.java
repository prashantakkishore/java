package com.pks.ds.tree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * This is an extension of below class.
 * @see com.pks.ds.tree.MaxWidthOfBT
 * 
 * Input : 
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 * 
 * Output : 22
 * 
 */


public class MaxSumByLevelBT extends TreeBase {

	public static int maxSumByLevel(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int maxSum = 0;

		while (!queue.isEmpty()) {

			int count = queue.size();
			int levelSum = 0;

			while (count > 0) {

				TreeNode node = queue.poll();
				levelSum += node.getData();

				if (node.getLeft() != null)
					queue.offer(node.getLeft());
				if (node.getRight() != null)
					queue.offer(node.getRight());

				count--;

			}

			maxSum = Math.max(maxSum, levelSum);

		}

		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println(maxSumByLevel(root));

	}

}
