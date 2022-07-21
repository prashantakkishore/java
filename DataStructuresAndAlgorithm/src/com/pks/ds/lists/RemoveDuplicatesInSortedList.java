package com.pks.ds.lists;

public class RemoveDuplicatesInSortedList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(2);
        removeDuplicate(node);
        printList(node);
    }

    public static Node removeDuplicate(Node head) {
        Node curr = head;
        while(curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void printList(Node node){
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}
