package com.jilani.msprep;


public class ReverseALinkedList {

	public static void main(String[] args) {

		for ( int i=1; i <= 10; i++)
			add(i);
		
		printList(head, "Original List");
		Node reverse = reverse(head);
		printList(reverse, " Reverse List");

	}
	
	static Node reverse ( Node head) {
		if ( head == null)
			return head;
		
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		while ( curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
	
	static Node head;

	static void printList(Node head, String message) {
		System.out.println(message);

		if (head == null) {
			System.out.println(" List is empty");
			return;
		}
		while (head.next != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.println(head.data);
		System.out.println();
	}
	
	
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

}
