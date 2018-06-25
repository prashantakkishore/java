package com.pks.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Input : 
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 * 
 * Output : 1 2 3 4 5 6 7
 * 
 */
public class LevelOrder extends TreeBase {

	public static void iterative(TreeNode root) {
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			
			TreeNode node = queue.poll();
			System.out.println(node.getData());
			
			if(node.getLeft() != null)
				queue.offer(node.getLeft());
			if(node.getRight() != null)
				queue.offer(node.getRight());	
		}
		
	}

	public static void main(String[] args) {
		
		iterative(root);

	}

}
