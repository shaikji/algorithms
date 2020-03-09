package com.jilani.linkedlist;

public class DeleteNNodesAfterMNodes {

	public static void main(String[] args) {
		
		for ( int i=1; i <= 10; i++) {
			add(i);
		}
		
		int m = 2;
		int n = 3;
		printList(head, "Original List");
		head = deleteNodesV2(head, n, m);
		printList(head, "List after deletion");

	}
	
	
	static Node deleteNodes(Node head, int n, int m) {
				
		if ( head == null || m <= 0 || n <=0 )
			return head;
		
		Node curr = head;
		int count = 0;
		Node prev = null;
		while ( count < m) {
			if ( curr == null)
				return head;
			prev = curr;
			curr = curr.next;
			count++;
		}
		
		// Delete N Nodes starting from curr
		
		count = 0;
		while ( count < n) {
			if ( curr == null) {
				prev.next = curr;
				return head;
			}
			count++;
			curr = curr.next;
		}
		
		prev.next = deleteNodes(curr, n, m);
		return head;
		
	}

	static Node deleteNodesV2(Node head, int n, int m) {
		
		if ( m <= 0 || n <=0 )
			return head;
		
		Node curr = head;
		Node temp = null;

		while ( curr != null) {
			
			for ( int i=1; i < m && curr != null; i++) {
				curr = curr.next;
			}
			
			if (curr == null)
				return head;
			
			temp = curr.next;
			
			for ( int i=1; i <= n && temp != null; i++) {
				temp = temp.next;
			}
			curr.next = temp;
			curr = temp;
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
