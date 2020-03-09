package com.jilani.linkedlist;

public class RotateLinkedList {

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++)
			add(i);

		printList(head, "Original List");
		int k = -3;
		head = rotateList(head, k);
		printList(head, "List after ratation counter clock-wise");

	}

	static Node rotateList(Node head, int k) {
		if (head == null || k == 0)
			return head;

		if (k < 0) {
			return rotateClockwise(head, -k);
		}

		return rotateCounterClockwise(head, k);
	}

	static Node rotateCounterClockwise(Node head, int k) {
		if (head == null || k <= 0)
			return head;

		int count = 0;
		Node curr = head;

		while (count < k - 1) {
			if (curr.next == null) {
				return head;
			}
			count++;
			curr = curr.next;
		}

		Node next = curr.next;

		if (next == null)
			return head;

		Node newHead = next;
		curr.next = null;

		while (next.next != null) {
			next = next.next;
		}
		next.next = head;

		return newHead;
	}
	
	// If you know the length of the list, then 
	// kthNode coutner-clockwise = len - k in clockwise

	// Find the k+1th node from the end
	// if it is null, then return original list
	// else
	// next of k+1th node = null
	// kth node is hte new head
	// link the last node to the original head.
	// Keep track of the last node.
	// If kth node is null, return original list

	static Node rotateClockwise(Node head, int k) {

		// Find 1st, kth and k+1th nodes from the end.
		
		Node lastNode = findKthNodeFromEnd(head, 1);
		Node kthNode = findKthNodeFromEnd(head, k);
		if ( kthNode == null)
			return head;
		Node kPlusOnethNode = findKthNodeFromEnd(head, k+1);
		if ( kPlusOnethNode == null)
			return head;
		
		lastNode.next = head;
		kPlusOnethNode.next = null;
		return kthNode;
	}

	private static Node findKthNodeFromEnd(Node head, int k) {

		int count = 0;

		Node main_ptr = head;
		Node ref_ptr = head;

		if ( main_ptr == null)
			return null;
		
		while (count < k) {

			if ( ref_ptr == null) {
				return null;
			}
			count++;
			ref_ptr = ref_ptr.next;
		}
		
		while ( ref_ptr != null) {
			ref_ptr = ref_ptr.next;
			main_ptr = main_ptr.next;
		}
		
		return main_ptr;
		
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
