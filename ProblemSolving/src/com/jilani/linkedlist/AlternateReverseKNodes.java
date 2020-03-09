package com.jilani.linkedlist;

public class AlternateReverseKNodes {

	public static void main(String[] args) {

		for (int i = 1; i <= 20; i++) {
			add(i);
		}

		printList(head, "Original List");
		int k = 3;
		//head = reverseAlternateNodes(head, k, true);
		head = reverseAlternateNodesV2(head, k);

		printList(head, "List after reversing");

	}

	static Node reverseAlternateNodes(Node head, int k, boolean flag) {

		int count = 0;
		Node curr = head;
		Node prev = null;
		Node next = null;

		if (flag) {
			// Reverse while traversing

			while (curr != null && count < k) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}
			
			if (next != null) {
				head.next = reverseAlternateNodes(next, k, !flag);
			}
			
		} else {
			Node old = null;
			while ( curr != null && count < k) {
				old = curr;
				next = curr.next;
				curr = next;
				count++;
			}
			if (next != null) {
				old.next = reverseAlternateNodes(next, k, !flag);
			}
		}
		
		return flag ? prev : head;

	}
	
	static Node reverseAlternateNodesV2(Node head, int k) {
		
		if ( head == null)
			return head;

		int count = 0;
		Node curr = head;
		Node prev = null;
		Node next = null;

		// Reverse while traversing

		while (curr != null && count < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		// If next != null, that means still more nodes are available.
		
		if ( next != null) {
			head.next = next;
		}

		count = 0;
		curr = next;
		
		while ( curr != null && count < k-1) {
			curr = curr.next;
			count++;
		}
		
		if ( curr != null)
			curr.next = reverseAlternateNodesV2(curr.next, k);

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
