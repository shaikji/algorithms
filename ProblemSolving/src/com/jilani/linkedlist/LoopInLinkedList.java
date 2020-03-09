package com.jilani.linkedlist;

public class LoopInLinkedList {

	public static void main(String[] args) {

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = new Node(9);
		head.next.next.next.next.next.next.next.next.next = new Node(10);
		
		// create a loop
		head.next.next.next.next.next.next.next.next.next.next 
			= head.next.next.next.next; 
		
		System.out.println(" loop exists "  + loopExists(head));
		
		removeLoopIfExists(head);
		
		printList(head, " After breaking the loop");
		
	}
	
	static boolean removeLoopIfExists( Node head) {
		
		if ( head == null || head.next == null)
			return false;
		
		Node slow = head;
		Node fast = head;
		
		do {
			slow = slow.next;
			fast = fast.next.next;
			
			if ( slow == fast) {
				slow = head;
				Node prev = null;
				while ( slow != fast) {
					prev = fast;
					slow = slow.next;
					fast = fast.next;
				}
				prev.next = null;
				break;
			}
				
		} while ( fast != null && fast.next != null);
		
		
		
		return false;
		
	}
	
	static boolean loopExists(Node head) {
		
		if ( head == null)
			return false;
		
		Node slow = head;
		Node fast = slow.next;
		
		
		while ( fast != null && fast.next != null) {
			
			if ( slow == fast) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return false;
		
	}
	
    static void printList(Node head, String message) {
        System.out.println(message);
        
        while ( head.next != null){
            System.out.print(head.data+ " -> ");
            head = head.next;
        }
        System.out.println(head.data);
        System.out.println();
    }
	
	static class Node{
		Node next;
		int data;
		Node(int data){
			this.data = data;
		}
	}
	
	static Node head;

}
