package com.jilani.linkedlist;

import java.util.HashSet;

public class DuplicationRemoverUnsorted {

	public static void main(String[] args) {

		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		add(1);
		add(2);
		add(3);
		add(4);

		printList(head, "Original List");
		head = removeDuplicatesHash(head);
		// head = remDupRec(head);
		printList(head, "List After removing duplicates");

	}

	// Using two loops O(n2)
	static Node removeDuplicates(Node head) {

		Node curr = head;
		Node fast = head;
		Node prev = null;

		while (curr != null) {

			fast = curr.next;
			prev = curr;
			while (fast != null) {
				if (fast.data == curr.data) {
					prev.next = fast.next;
				} else {
					prev = fast;
				}

				fast = fast.next;
			}

			curr = curr.next;
		}

		return head;
	}

	// Remove duplicates in an unsorted list using Hashing

	static Node removeDuplicatesHash(Node head) {

		Node curr = head;
		Node prev = head;
		HashSet<Integer> set = new HashSet();

		while (curr != null) {

			if (set.contains(curr.data)) {
				// Remove the curr node;
				prev.next = curr.next;
			} else {
				set.add(curr.data);
				prev = curr;
			}

			curr = curr.next;
		}

		return head;
	}

	static Node remDupRec(Node head) {

		if (head == null)
			return null;

		Node next = remDupRec(head.next);
		if (next != null && next.data == head.data) {
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
