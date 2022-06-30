package com.pks.ds.tree.BT;

import com.pks.ds.tree.TreeBase;
import com.pks.ds.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxSumByLevel2 extends TreeBase {


    public static void main(String[] args) {
        System.out.println(maxByLevel(root));
    }

    private static boolean maxByLevel(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = 0;

        while(!queue.isEmpty()) {
            int count = queue.size();
            int levelSum = 0;

            while(count > 0) {

                TreeNode node = queue.remove();
                levelSum+=node.getData();

                if (node.getLeft() != null)
                    queue.add(node.getLeft());
                if (node.getRight() != null)
                    queue.add(node.getRight());

                count --;

            }
            maxSum = Math.max(levelSum, maxSum);
            System.out.println(maxSum);
        }
        return true;

    }
}
