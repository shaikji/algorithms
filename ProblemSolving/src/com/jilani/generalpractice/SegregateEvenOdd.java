package com.jilani.generalpractice;

public class SegregateEvenOdd {

	public static void main(String[] args) {
		
		// 1 -> 2 -> 3 -> 4 -> 5 -> 6
		// 2 ->  -> 4 -> -> 6
		
		// dummy -> 1   -> 3 (tail )
		
		/*
		 * for ( int i=1 ; i <= 10; i++) add(i);
		 */
		
		add(1);
		add(3);
		add(5);
		add(8);
		

		printList(head, "Original List ");
		head = process(head);
		printList(head, "Processed List ");

	}
	
	static Node process (Node head) {
		
		if ( head == null )
			return null;
		
		Node curr = head;
		Node dummy = new Node(-1);
		Node tail = dummy;
		Node prev = null;
		Node next = null;
		Node newHead = null;
		
		
		// 1 3 5 7
		// First let us process the list until it hits the first even node;
		while ( curr != null && curr.data %2 != 0) {	
			next = curr.next;
			tail.next = curr;
			tail = curr;
			tail.next = null;
			curr = next;
		}
		
		// All are odd nodes, could not find any even node:
		if ( curr == null)
			return dummy.next;
		
		
		//  1 3 5 8 9 10 11 12
		
		// even -> 8 -> 10 -> 12 (prev) - NULL (curr)
		// dummy -> 1 -> 3 -> 5 -> 11 
		// I found first even node;	
		newHead = curr;
		prev = curr;
		curr = curr.next;
		
		while ( curr != null) {
			
			if ( curr.data %2 == 1 ) {
				prev.next = curr.next;
				tail.next = curr;
				tail = curr;
				tail.next = null;
				curr = prev.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		
		prev.next = dummy.next;
		return newHead;
		
		
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
