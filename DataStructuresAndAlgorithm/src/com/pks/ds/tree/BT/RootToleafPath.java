package com.pks.ds.tree.BT;

import com.pks.ds.tree.TreeBase;
import com.pks.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToleafPath extends TreeBase {

    public static void main(String[] args) {
        rootToLeafPath(root, new ArrayList<Integer>());
    }

    private static void rootToLeafPath(TreeNode node, List<Integer> path) {

        path.add(node.getData());
        if (node.isLeaf()){
            path.forEach(System.out::println);
            System.out.println("Done::");
        } else {

            rootToLeafPath(node.getLeft(), new ArrayList<Integer>(path));
            rootToLeafPath(node.getRight(), new ArrayList<Integer>(path));
        }


    }
}
