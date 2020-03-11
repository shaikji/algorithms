package com.jilani.linkedlist;

public class IntersectionOfTwoSortedLists {

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++)
			add(i);

		second = new Node(2);
		second.next = new Node(4);
		second.next.next = new Node(8);
		second.next.next.next = new Node(15);
		
		printList(head, " List 1 ");
		printList(second, " List 2 ");

		Node node = findIntersection(head, second);

		printList(node, " Intersection List ");
	}


	static Node findIntersection(Node first, Node second) {

		if (first == null || second == null)
			return null;
		
		Node p = first;
		Node q = second;
		Node dummy = new Node(-1);
		Node tail = dummy;
		
		while ( p != null && q != null) {
			if ( p.data == q.data ) {
				tail.next = new Node(p.data);
				tail = tail.next;
				p = p.next;
				q = q.next;
			} else if ( p.data < q.data) {
				p = p.next;
			} else {
				q = q.next;
			}
		}

		return dummy.next;
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
