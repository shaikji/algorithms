package com.jilani.linkedlist;

public class PairwiseSwap {

	public static void main(String[] args) {

		for (int i = 1; i <= 1; i++)
			add(i);

		printList(head, "Original List");
		// head = swap(head);
		head = swapIterativeV2(head);
		printList(head, "After pairwise swap");
	}

	static Node swap(Node curr) {

		if (curr == null || curr.next == null)
			return curr;

		Node swapped = swap(curr.next.next);
		Node next = curr.next;

		curr.next.next = curr;
		curr.next = swapped;

		return next;

	}

	static Node swapIterative(Node head) {

		Node curr = head;

		if (curr == null || curr.next == null)
			return head;

		Node newHead = curr.next;

		Node next = curr.next.next;
		curr.next.next = curr;
		Node prev = curr;
		curr = next;

		while (curr != null && curr.next != null) {
			next = curr.next.next;
			curr.next.next = curr;
			prev.next = curr.next;
			prev = curr;
			curr = next;
		}

		if (curr != null) {
			prev.next = curr;
		}

		return newHead;

	}

	static Node swapIterativeV2(Node head) {


		if (head == null || head.next == null)
			return head;

		Node prev = head;
		Node curr = head.next;
		Node newHead = curr;
		Node next = null;
		
		while ( true ) {
			next = curr.next;
			curr.next = prev;
			
			if ( next == null || next.next == null) {
				prev.next = next;
				break;
			}
			
			prev.next = next.next;
			prev = next;
			curr = next.next;
		}
		
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

	static class ThreePointers {
		Node node;
		Node next;
		Node prev;

		ThreePointers(Node node, Node next, Node prev) {
			this.node = node;
			this.next = next;
			this.prev = prev;
		}

		public ThreePointers() {
			// TODO Auto-generated constructor stub
		}
	}

}
