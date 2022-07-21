package com.pks.ds.lists;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Node one = new Node(2);
        one.next = new Node(4);
        one.next.next = new Node(3);
        // second
        Node two = new Node(5);
        two.next = new Node(6);
        two.next.next = new Node(8);
        printList(addTwoNumbers(one, two));
    }

    // O(max(m,n))
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node result = new Node(-1);
        Node head = result;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = (l1 != null) ? l1.data : 0;
            int num2 = (l2 != null) ? l2.data : 0;
            // When both are null , carry will create new node
            int sum = num1 + num2 + carry;
            result.next = new Node(sum % 10);
            result = result.next;
            carry = sum / 10;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return head.next;

    }

    public static void printList(Node node){
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
}
