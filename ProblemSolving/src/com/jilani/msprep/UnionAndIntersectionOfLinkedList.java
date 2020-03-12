package com.jilani.msprep;

import java.util.HashSet;
import java.util.Set;

// Assume both lists have non duplicate elements

public class UnionAndIntersectionOfLinkedList {

	public static void main(String[] args) {

		head1 = new Node(10);
		head1.next = new Node(15);
		head1.next.next = new Node(4);
		head1.next.next.next = new Node(20);

		head2 = new Node(8);
		head2.next = new Node(4);
		head2.next.next = new Node(2);
		head2.next.next.next = new Node(10);
		

		Node union = union(head1, head2);
		Node intersection = intersection(head1, head2);
		
		
		printList(head1, "List 1");
		printList(head2, "List 2");
		printList(union, " Union List" );
		printList(intersection, " Intersection List" );


	}
	
	static Node union(Node head1, Node head2 ) {
		
		if ( head1 == null)
			return head2;
		if ( head2 == null)
			return head1;
		
		Set<Integer> set = new HashSet();
		
		Node union = new Node(-1);
		Node tail = union;
		
		Node curr = head1;
		
		while (curr != null) {
			set.add(curr.data);
			tail.next = new Node(curr.data);
			tail = tail.next;
			curr = curr.next;
		}
		
		// Add list 2 items
		
		curr = head2;
		
		while ( curr != null) {
			if ( !set.contains(curr.data)) {
				tail.next = new Node(curr.data);
				tail = tail.next;
			}
			curr = curr.next;
		}
		tail.next = null;
		return union.next;
		
	}
	
	static Node intersection(Node head1, Node head2 ) {
		
		if ( head1 == null || head2 == null)
			return null;
		
		Set<Integer> set = new HashSet();
		
		Node intersection = new Node(-1);
		Node tail = intersection;
		
		Node curr = head1;
		
		while (curr != null) {
			set.add(curr.data);
			curr = curr.next;
		}
		
		// Add list 2 items
		
		curr = head2;
		
		while ( curr != null) {
			if ( set.contains(curr.data)) {
				tail.next = new Node(curr.data);
				tail = tail.next;
			}
			curr = curr.next;
		}
		tail.next = null;
		return intersection.next;
		
	}
	
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static Node head1, head2;

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
