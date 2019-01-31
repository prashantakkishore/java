package com.pks.ds.tree.BT;

import java.util.LinkedList;
import java.util.Queue;

import com.pks.ds.tree.TreeBase;
import com.pks.ds.tree.TreeNode;

/**
 * 
 * Eg : 
     	 1
        /  \
       2    3
     /  \     \
    4    5     8 
              /  \
             6    7
 * 
 * 
 * Exp:
 * For the above tree,
 * width of level 1 is 1,
 * width of level 2 is 2,
 * width of level 3 is 3
 * width of level 4 is 2.
 * 
 * 
 * So maximum width of the tree is 3.
 * 
 * 
 * Input : 
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 * 
 * Output : 4
 */
public class MaxWidthOfBT extends TreeBase {
	
	public static int maxWidth(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int width = 0;

		while (!queue.isEmpty()) {

			int count = queue.size();
			width = Math.max(width, count);

			while (count > 0) {

				TreeNode node = queue.poll();

				if (node.getLeft() != null)
					queue.offer(node.getLeft());
				if (node.getRight() != null)
					queue.offer(node.getRight());

				count--;

			}

		}

		return width;

	}

	public static void main(String[] args) {
		System.out.println(maxWidth(root));
	}

}
