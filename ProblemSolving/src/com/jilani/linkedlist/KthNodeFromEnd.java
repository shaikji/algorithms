package com.jilani.linkedlist;

public class KthNodeFromEnd {

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++)
			add(i);

		printList(head, "Original List");

		for (int i = 0; i <= 15; i++) {
			System.out.println(i + "th from end = " + kthFromEnd(head, i));
		}

		System.out.println("10 th from end = " + kthFromEnd(head, 10));
	}

	static int kthFromEnd(Node head, int k) {

		if (head == null || k <= 0) {
			return -1;
		}

		Node main_ptr = head;
		Node ref_ptr = head;

		int count = 0;

		while (count < k) {
			if (ref_ptr == null) {
				return -1;
			}

			count++;
			ref_ptr = ref_ptr.next;
		}

		while (ref_ptr != null) {
			ref_ptr = ref_ptr.next;
			main_ptr = main_ptr.next;
		}
		return main_ptr.data;
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

		Node node = new Node(data);
		if (head == null) {
			head = node;
			return;
		}

		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = node;
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
