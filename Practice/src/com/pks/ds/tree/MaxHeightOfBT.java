package com.pks.ds.tree;
/**
 * 
 * Input : 
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 * 
 * Output : 3
 * 
 */
public class MaxHeightOfBT extends TreeBase {

	public static int maxDepth(TreeNode root) {
		
		if (root == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(root.getLeft());
			int rDepth = maxDepth(root.getRight());

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(maxDepth(root));

	}

}
