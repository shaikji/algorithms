package com.jilani.linkedlist;

public class SearchAnElement {

	public static void main(String[] args) {
		
		for ( int i=1; i <= 10; i++)
			add(i);
		
		for ( int i= 0; i <= 20; i++) {
			System.out.println(i + " Exists = " + existsRec(head, i));
			System.out.println(i + " Exists = " + existsNonRec(head, i));

		}
		
		Node node = searchRec(head, 5);
		if ( node == null)
			System.out.println(" Element not found");
		else 
			System.out.println(" Element found");
		
		
		node = searchNonRec(head, 5);
		if ( node == null)
			System.out.println(" Element not found");
		else 
			System.out.println(" Element found");
		
		node = searchRec(head, 15);
		if ( node == null)
			System.out.println(" Element not found");
		else 
			System.out.println(" Element found");
		
		
		node = searchNonRec(head, 15);
		if ( node == null)
			System.out.println(" Element not found");
		else 
			System.out.println(" Element found");
				
	}
	
	static boolean existsRec( Node head, int k) {
		if( head == null)
			return false;
		if ( head.data == k) {
			return true;
		}else {
			return existsRec(head.next, k);
		}
	}
	
	static boolean existsNonRec(Node head, int elem) {
		if ( head == null)
			return false;
		Node curr = head;
		while ( curr != null) {
			if ( curr.data == elem)
				return true;
			curr = curr.next;
		}
		return false;
	}
	
	
	static Node searchRec( Node head, int k) {
		if( head == null)
			return head;
		if ( head.data == k) {
			return head;
		}else {
			return searchRec(head.next, k);
		}
	}
	
	static Node searchNonRec(Node head, int elem) {
		if ( head == null)
			return head;
		Node curr = head;
		while ( curr != null) {
			if ( curr.data == elem)
				return curr;
			curr = curr.next;
		}
		return null;
	}
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static Node head;

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

		while (head.next != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.println(head.data);
		System.out.println();
	}

}
