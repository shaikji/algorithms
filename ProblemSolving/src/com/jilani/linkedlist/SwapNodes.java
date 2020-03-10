package com.jilani.linkedlist;

public class SwapNodes {

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++)
			add(i);

		printList(head, "Original List");
		head = swapNodes(head, 1, 10);
		printList(head, "List after swapping");

	}

	static Node swapNodes(Node head, int x, int y) {

		ThreePointers tp1 = findNode(x);
		ThreePointers tp2 = findNode(y);

		if (tp1.node == null || tp2.node == null)
			return head;

		if (tp1.prev == null || tp2.prev == null) {
			tp1.node.next = tp2.next;
			tp2.prev.next = tp1.node;
			tp2.node.next = tp1.next;	
			return tp2.node;
		} else if (tp2.prev == null) {
			tp2.node.next = tp1.next;
			tp1.prev.next = tp2.node;
			tp1.node.next = tp2.next;
			return tp1.node;
		} else {
			tp1.prev.next = tp2.node;
			tp2.node.next = tp1.next;
			tp2.prev.next = tp1.node;
			tp1.node.next = tp2.next;
			return head;
		}

	}

	static ThreePointers findNode(int data) {
		ThreePointers tp = new ThreePointers();

		if (head == null)
			return tp;

		Node curr = head;
		Node prev = null;
		while (curr != null) {
			if (curr.data == data) {
				tp.node = curr;
				tp.next = curr.next;
				tp.prev = prev;
				return tp;
			}
			prev = curr;
			curr = curr.next;
		}

		return tp;
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
