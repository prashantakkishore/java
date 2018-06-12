package com.pks.ds.lists;

public class Reverse {
	
	Node head; //used in recursive method
	
	public Node reverse_Iterative(Node node){
		Node curr = node;
		Node prev = null;
		Node next = null;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		node = prev;
		return node;
		
	}
	
	/**
	 * Tail Recursive Method
	 * @param curr
	 * @param prev
	 * @return
	 */
	
	public Node reverse_Recursive(Node curr, Node prev){
		/* If last node mark it head*/
        if (curr.next == null) {
            head = curr;
 
            /* Update next to prev node */
            curr.next = prev;
             
            return head;
        }
 
        /* Save curr->next node for recursive call */
        Node next1 = curr.next;
 
        /* and update next ..*/
        curr.next = prev;
 
        reverse_Recursive(next1, curr);
        return head;
	}
	
	public static void main(String[] args) {
		
		Reverse list = new Reverse();
		
        Node node = new Node(85);
        node.next = new Node(15);
        node.next.next = new Node(4);
        node.next.next.next = new Node(20);
         
        System.out.println("Given Linked list");
        list.printList(node);
        Node reversedHead = list.reverse_Iterative(node);
        System.out.println("");
        System.out.println("ITERATIVE - Reverse ");
        list.printList(reversedHead);
        
        
        Node node1 = new Node(85);
        node1.next = new Node(15);
        node1.next.next = new Node(4);
        node1.next.next.next = new Node(20);
        
        Node reversedListRecursive = list.reverse_Recursive(node1, null);
        System.out.println("RECURSIVE - Reverse");
        list.printList(reversedListRecursive);
	}
	
	public void printList(Node node){
		while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
		System.out.println("null");
	}

}
