package com.jilani.linkedlist;

public class IntersectionPoint {

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++)
			add(i);

		second = new Node(11);
		second.next = new Node(12);
		second.next.next = new Node(13);
		second.next.next.next = head.next.next.next;// .next.next.next.next.next;

		printList(head, " List 1 ");
		printList(second, " List 2 ");

		Node node = findIntersectionPoint(head, second);

		System.out.println(" Intersection Point = " + node.data);

	}

	static int getLength(Node node) {
		if (node == null)
			return 0;

		Node curr = node;
		int len = 0;
		while (curr != null) {
			curr = curr.next;
			len++;
		}
		return len;
	}

	static Node findIntersectionPoint(Node head, Node second) {

		if (head == null || second == null)
			return null;

		int c1 = getLength(head);
		int c2 = getLength(second);

		if (c1 >= c2) {
			return findIntersection(c1 - c2, head, second);
		} else {
			return findIntersection(c2 - c1, second, head);
		}

	}
	
	static Node findIntersection ( int d, Node big, Node small) {
		
		Node curr1 = big;
		
		while ( d > 0 ) {
			curr1 = curr1.next;
			d--;
		}
		
		Node curr2 = small;
		
		while ( curr1 != curr2) {
			if ( curr1 == null || curr2 == null)
				return null;
			curr2 = curr2.next;
			curr1 = curr1.next;
		}
		
		return curr1;
	}

	static Node head;
	static Node second;

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
