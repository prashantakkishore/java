package com.pks.ds.lists;

public class CheckIfCircular {

    public static void main(String[] args) {
        Node node = new Node(85);
        node.next = new Node(15);
        node.next.next = new Node(4);
        node.next.next.next = new Node(20);
        //node.next.next.next.next = node;
        System.out.println(isCircular(node));
    }

    public static boolean isCircular(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node node = head.next;
        while(node != null && head != node) {
            node = node.next;
        }
        return head == node;
    }
}
