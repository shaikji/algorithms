package com.jilani.linkedlist;

public class FindTheLength {

	public static void main(String[] args) {
		
		for ( int i=1; i <= 10; i++)
			add(i);
		
		System.out.println(" Length Recursive = " + findLengthRecursive(head));
		
		System.out.println(" Length Iterative = " + findLengthIterative(head));
		
	}
	
	static int findLengthRecursive( Node head) {
		if( head == null)
			return 0;
		return 1 + findLengthRecursive(head.next);
	}
	
	static int findLengthIterative(Node head) {
		if ( head == null)
			return 0;
		Node curr = head;
		int count = 0;
		while ( curr != null) {
			curr = curr.next;
			count++;
		}
		return count;
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
