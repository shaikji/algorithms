package com.jilani.linkedlist;

public class DuplicationRemover {

	public static void main(String[] args) {
		
		add(1);
		add(2);
		add(2);
		add(2);
		add(3);
		add(3);
		add(4);
		add(4);
		add(5);
		
		printList(head, "Original List");
		//head = removeDuplicates(head);
		head = remDupRec(head);
		printList(head, "List After removing duplicates");

	}
	
	static Node removeDuplicates( Node head) {
		
		Node curr = head;
		Node fast = head;
		
		while ( curr != null) {
			
			fast = curr.next;
			while ( fast != null && fast.data == curr.data) {
				fast = fast.next;
			}
			curr.next = fast;
			curr = curr.next;
		}
		
		return head;
	}
	
	static Node remDupRec(Node head) {
		
		if ( head == null)
			return null;
		
		Node next = remDupRec(head.next);
		if ( next != null && next.data == head.data) {
			head.next = next.next;
		} else {
			head.next = next;
		}
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
		while (head.next != null) {
			System.out.print(head.data + " -> ");
			head = head.next;
		}
		System.out.println(head.data);
		System.out.println();
	}
}
