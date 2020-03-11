package com.jilani.generalpractice;

public class PairwiseSwapping {

	public static void main(String[] args) {
		
		// INput:  (head) 1 2          node ->    4 3 6 5 8 7 
		// Output: 2 1 4 3 6 5 8 7 
		
		// INput:  1 2 3 4 5 6 7
		// Output: 2 1 4 3 6 5 7
		
		// Recursive Approach
		// 1 2 3 4 5 6 7 8 
		
		for ( int i=1; i <= 10; i++)
			add(i);
		
		printList(head, "Original List");
		head = swapIterative(head);
		printList(head, "Original List");


	}
	
	static Node swapIterative ( Node head) {
		
		if ( head == null || head.next == null)
			return head;
		
		// 1  2  3  4  5  6  7  8 
		
		Node newHead = head.next;
		
		Node curr = head;
		Node next = null;
		Node prev = null;
		
		next = curr.next.next;
		curr.next.next = curr;
		prev = curr;
		curr = next;
		
		while ( curr != null && curr.next != null) {
			next = curr.next.next;
			curr.next.next = curr;
			prev.next = curr.next;
			prev = curr; 
			curr = next;
		}
		prev.next = curr;
		
		return newHead;
		
	}
	
	
	static Node swap (Node head) {
		
		if ( head == null || head.next == null) {
			return head;
		}
		
		// head != null && head.next != null
		Node node = swap(head.next.next);
	
		Node newHead = head.next;
		head.next.next = head;
		head.next = node;
		
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
