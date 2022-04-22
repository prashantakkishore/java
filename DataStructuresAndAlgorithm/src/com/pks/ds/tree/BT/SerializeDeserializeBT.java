package com.pks.ds.tree.BT;

import com.pks.ds.tree.BT.traversal.PreOrder;
import com.pks.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solution/
 * Input :
 * 			    1
 * 			 /    \
 * 		   2	    3
 * 		 /   \    /   \
 * 	   4	  5	 6	   7
 *
 *  Process preorder
 * Input: root = [1,2,4,#,7,#,#,5,#,#,3,6,#,#,#]
 * Output: [1,2,4,#,7,#,#,5,#,#,3,6,#,#,#]
 * PreOrder: [1 2 4 7 5 3 6];
 */
public class SerializeDeserializeBT {

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node4.setRight(node7);

        // Both sop should be equal
        preOrder(node1);
        System.out.println();
        String treeString = serialize(node1);
        System.out.println(treeString);
        Node deNode = deserialize(treeString);
        preOrder(deNode);
        System.out.println();
        list.clear();
        String treeStringDeNode = serialize(deNode);
        System.out.println(treeStringDeNode);

    }


    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        if(root == null) {
            list.add("#");
            return null;
        }
        list.add(root.getData().toString());
        serialize(root.getLeft());
        serialize(root.getRight());

        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        if (data == null)
            return null;
        String[] arr = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(arr));
        return helper(dataList);
    }
    public static Node helper(List<String> dataList )
    {
        if (dataList.get(0).equals("#")) {
            dataList.remove(0);
            return null;
        }
        // create node with this item and recur for children
        Node root = new Node(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = helper(dataList);
        root.right = helper(dataList);
        return root;
    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    static class Node{
        private Node left;
        private Node right;
        private Integer data;

        public Node(Integer data){
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }
    }
}
