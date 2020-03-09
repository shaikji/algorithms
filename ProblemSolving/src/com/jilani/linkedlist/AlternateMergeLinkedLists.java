package com.jilani.linkedlist;

public class AlternateMergeLinkedLists {

	public static void main(String[] args) {
		
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		//head1.next.next.next = new Node(4);
		//head1.next.next.next.next = new Node(5);

		head2 = new Node(6);
		head2.next = new Node(7);
		head2.next.next = new Node(8);
		head2.next.next.next = new Node(9);
		head2.next.next.next.next = new Node(10);

		
		printList(head1, "List 1");
		printList(head2, "List 2");
		
		mergeLists();
		
		printList(head1, "List 1 After Merging");
		printList(head2, "List 2 After Merging");
		

	}
	static void mergeLists() {
		
		if( head1 == null || head2 == null) {
			return;
		}
		
		Node p = head1;
		Node q = head2;
		Node pNext, qNext;
		
		while ( p != null && q != null) {
			pNext = p.next;
			qNext = q.next;
			
			p.next = q;
			q.next = pNext;
			
			p = pNext;
			q = qNext;
		}	
		head2 = q;
	}
	
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static Node head1;
	static Node head2;

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
