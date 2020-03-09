package com.jilani.linkedlist;

public class DeleteOccuranceOfElement {

	public static void main(String[] args) {
		
		for ( int i=1; i <= 5; i++) {
			add(i);
		}
		
		add(5);
		add(7);
		add(5);
		add(9);
	
		add(1);
		add(3);
		printList(head, "Original List");
		head = deleteLastOccuranceOf(head, 5);
		printList(head, "List after deleting");

		head = deleteFirstOccuranceOf(head, 3);
		printList(head, "List after deleting first Occurance");
		
	}
	
	static Node deleteFirstOccuranceOf(Node head, int k) {
		
		if ( head == null)
			return head;
		
		Node curr = head;
		Node prev = null;
		
		while (curr != null) {
			
			if ( curr.data == k ) {
				break;
			}
			
			prev = curr;
			curr = curr.next;
		}
		
		if ( curr == null) {
			System.out.println(" Element not found");
			return head;
		}
		if ( prev == null) {
			head = head.next;
		} else {
			prev.next = curr.next;
		}
		return head;
	}
	
	static Node deleteLastOccuranceOf(Node head, int k) {
		
		if ( head == null)
			return head;
		
		Node toBeDeleted = null;
		Node prevToDelete = null;
		
		Node curr = head;
		Node prev = null;
		
		while ( curr != null) {
			if ( curr.data == k) {
				toBeDeleted= curr;
				prevToDelete = prev; 
			}
			prev = curr;
			curr = curr.next;
		}
		
		if ( toBeDeleted == null) {
			System.out.println(" Element not found");
		}
		
		if ( prevToDelete == null)
			head = head.next;
		else
			prevToDelete.next = toBeDeleted.next;
		
		return head;
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static Node head;
	static Node left;

	static void add(int data) {

		if (head == null) {
			head = new Node(data);
			return;
		}

		Node curr = head;

		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node(data);
	}
	
	   static void printList(Node head, String message) {
	        System.out.println(message);
	        
	        if (head == null) {
	        	System.out.println(" List is empty");
	        	return;
	        }
	        while ( head.next != null){
	            System.out.print(head.data+ " -> ");
	            head = head.next;
	        }
	        System.out.println(head.data);
	        System.out.println();
	    }
}
