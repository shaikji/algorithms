package com.jilani.linkedlist;


public class LinkedList {
	
	Node head = null;

 
	
	void insert(int data) {
		
		Node node = new Node(data);
		
		if ( head == null) {
			head = node;
			return;
		}
		
		Node curr = head;
		
		while ( curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = node;
	}
	
	
	void printList () {
		
		if ( head == null) {
			System.out.println(" List is empty");
			return;
		}
		
		Node curr = head;
		
		while ( curr.next != null) {
			System.out.print( curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}
	
	void printMiddle() {
		
		if ( head == null) {
			System.out.println("List is empty - no middle element");
			return;
		}
		
		Node slow = head;
		Node fast = head.next;
		
		while ( fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		System.out.println(" Middle of the list = " + slow.data);
	}
 
}
