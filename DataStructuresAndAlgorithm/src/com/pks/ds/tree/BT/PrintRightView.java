package com.pks.ds.tree.BT;

import com.pks.ds.tree.TreeBase;
import com.pks.ds.tree.TreeNode;

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
 *                \
 *                 8
 * Output : 1 3 7 8
 *
 */
public class PrintRightView extends TreeBase {

    public static void iterative(com.pks.ds.tree.TreeNode root) {

        Queue<com.pks.ds.tree.TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (i == queueSize - 1 ) {
                    System.out.println(node.getData());
                }
                if (node.getLeft() != null)
                    queue.offer(node.getLeft());
                if (node.getRight() != null)
                    queue.offer(node.getRight());
            }

        }

    }

    public static void main(String[] args) {
        root.getRight().getLeft().setRight(new TreeNode(8));
        iterative(root);

    }
}
