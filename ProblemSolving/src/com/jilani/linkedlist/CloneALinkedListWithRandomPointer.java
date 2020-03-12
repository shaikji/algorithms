package com.jilani.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneALinkedListWithRandomPointer {

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++)
			add(i);

		head.random = head.next.next;
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next;
		head.next.next.next.next.random = head.next;

		printList(head, "Original list");
		// Node cloned = clone(head);
		Node cloned = cloneV2(head);
		printList(cloned, "Cloned list");

	}

	// second version

	static Node cloneV2(Node head) {

		if (head == null)
			return head;

		Node curr = head;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = new Node(curr.data);
			curr.next.next = next;
			curr = next;
		}

		// Update Random pointers

		curr = head;

		while (curr != null) {
			curr.next.random = curr.random;
			curr = curr.next.next;
		}

		// Restore the list

		curr = head;
		Node cloned = curr.next;
		curr.next = curr.next.next;
		Node temp = cloned;
		curr = curr.next;

		while (curr != null) {
			temp.next = curr.next;
			curr.next = curr.next.next;
			temp = temp.next;
			curr = curr.next;
		}

		return cloned;
	}

	static Node clone(Node head) {

		if (head == null)
			return head;

		Map<Node, Node> map = new HashMap<Node, Node>();

		Node curr = head;
		while (curr != null) {
			map.put(curr, new Node(curr.data));
			curr = curr.next;
		}

		Node currX = head;
		Node currY = null;

		while (currX != null) {
			currY = map.get(currX);
			currY.next = map.get(currX.next);
			currY.random = map.get(currX.random);
			currX = currX.next;
		}

		return map.get(head);

	}

	static class Node {
		int data;
		Node next;
		Node random;

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
			System.out.print(head.data + " (" + ((head.random == null) ? null : head.random.data) + ")  -> ");
			head = head.next;
		}
		System.out.print(head.data + " (" + ((head.random == null) ? null : head.random.data) + ")");
		System.out.println();
	}

}
