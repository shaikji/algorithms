package com.jilani.linkedlist;

import com.jilani.linkedlist.PairwiseSwap.Node;

public class SegregateEvenOdd {

	public static void main(String[] args) {

		for (int i = 1; i <= 20; i++)
			add(i);

		printList(head, "Original List");
		head = evenOddV2(head);
		printList(head, "List after segregation");

	}

	static Node evenOdd(Node head) {
		if (head == null || head.next == null)
			return head;

		Node dummy = new Node(-1);
		Node tail = dummy;

		Node curr = head;
		Node prev = null;
		Node next = null;

		while (curr != null && curr.data % 2 == 1) {
			next = curr.next;
			tail.next = curr;
			tail = curr;
			tail.next = null;
			curr = next;
		}

		if (curr == null)
			return dummy.next;

		// Now you are pointing to an even node
		// make that as head;

		Node newHead = curr;

		prev = curr;
		curr = curr.next;
		next = null;
		while (curr != null) {
			if (curr.data % 2 == 1) {
				next = curr.next;
				prev.next = curr.next;
				tail.next = curr;
				tail = curr;
				tail.next = null;
				curr = next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		// first even, then odd.

		prev.next = dummy.next;

		return newHead;

	}

	// Here go to last Node of the list.
	// Start visiting the list again, if you find odd node append it at the end
	// Go to the lastNode
	// Move all the ODD nodes before lastNode to next of lastNode
	// Make the first EVEN node as newHead if one exists.
	// Now move all the ODD nodes before lastNode to the next of lastNode.

	static Node evenOddV2(Node head) {

		if (head == null || head.next == null)
			return head;

		// Go to last node

		Node last = head;
		Node newHead = null;

		while (last.next != null)
			last = last.next;
		Node tail = last;

		// Until you hit the first even node, Move all the odd nodes from the beginning
		// of the list to the next of last node

		Node curr = head;
		Node next = null;

		while (curr != last && curr.data % 2 != 0) {
			next = curr.next;
			curr.next = null;
			tail.next = curr;
			tail = curr;
			curr = next;
		}

		// Did you find the even node? or did you hit the last node?

		if (curr.data % 2 == 0) {
			// You hit the even case.
			newHead = curr;
			Node prev = null;
			while (curr != last) {
				if (curr.data % 2 == 1) {
					next = curr.next;
					prev.next = curr.next;
					tail.next= curr;
					tail = curr;
					tail.next = null;
					curr = next;
				} else {
					prev = curr;
					curr = curr.next;
				}
			}
			
			if ( curr.data %2 == 1 ) {
				prev.next = last.next;
				tail.next = last;
				last.next = null;
			}
		} else {
			//
			newHead = last.next;
			tail.next = last;
			tail = last;
			last.next = null;
		}
		
		return newHead;

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
