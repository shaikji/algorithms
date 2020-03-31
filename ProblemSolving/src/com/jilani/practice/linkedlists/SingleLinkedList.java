package com.jilani.practice.linkedlists;

public class SingleLinkedList {

	public static void main(String[] args) {
		
		/*
		 * for ( int i=1; i <= 7; i++) { add(i); add(i); printList(head);
		 * System.out.println(" Middle of the list = " + getMiddle(head)); }
		 * 
		 * for ( int i=0; i <= 9; i++) { System.out.println(i + " occurred " +
		 * countOccuranceOf(i, head) + " times "); }
		 */
		
		createListAndMakeLoop();
		
		System.out.println(" Loop exists = " + loopExists(head));
		
		removeLoop(head);
		printList(head);
		
//		for ( int k=0; k <= 10; k++)
//			System.out.println(k+"th from end = " + getNthNodeFromEnd(head,k));
		/*
		 * System.out.println(" Length = " + length(head));
		 * System.out.println(" Length = " + lengthRec(head));
		 * 
		 * head = reverse(head); printList(head);
		 */	
	}
	
	static boolean loopExists(Node head) {
		
		if ( head == null)
			return false;
		
		Node slow = head;
		Node fast = head.next;
		
		while ( fast != null && fast.next != null ) {
			if ( slow == fast)
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return false;
	}
	
	static void removeLoop(Node head) {
		
		if ( head == null)
			return;
		
		Node slow = head;
		Node fast = head;
		
		boolean loopExists = false;
		
		while ( fast != null && fast.next != null ) {
			slow = slow.next;
			fast = fast.next.next;			
			if ( slow == fast) {
				loopExists = true;
				break;
			}
		}
		
		Node p = slow.next;
		int len = 1;
		
		while ( p != slow) {
			p = p.next;
			len++;
		}
		System.out.println(" Loop length = " + len);
		
		slow = head;
		Node prev = null;
		
		
		
		
		
		
		
		
		
		while ( slow != fast) {
			prev = fast;
			slow = slow.next;
			fast = fast.next;
		}
		
		prev.next = null;
	}
	
	static void createListAndMakeLoop() {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = new Node(9);
		head.next.next.next.next.next.next.next.next.next = new Node(10);
		head.next.next.next.next.next.next.next.next.next.next = head.next.next.next.next;
	}
	
	static int length(Node head) {
		if ( head == null)
			return 0;
		
		int len = 0;
		Node curr = head;
		while ( curr != null) {
			len++;
			curr = curr.next;
		}
		return len;
	}
	
	static int lengthRec(Node head) {
		if (head == null)
			return 0;
		return 1 + lengthRec(head.next);
	}
	
	
	static int getMiddle(Node head) {
		if ( head == null)
			return -1;
		
		return findMiddle(head).data;
	}
	
	static Node findMiddle(Node head) {
		
		Node slow = head;
		Node fast = head;
		Node prev = null;
		
		while ( fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		
		return fast == null ? prev: slow;
	}
	
	static int countOccuranceOf(int elem, Node head) {
		
		if ( head == null)
			return 0;
		
		Node curr = head;
		int count = 0;
		while ( curr != null) {
			if (curr.data == elem)
				count++;
			curr = curr.next;
		}
		return count;
	}
	
	static int getNthNode(Node head, int n) {
		if ( head == null || n <=0)
			return -1;
		
		Node curr = head;
		int count =1;
		
		while ( curr != null) {
			
			if ( count == n) {
				return curr.data;
			}
			count++;
			curr = curr.next;
		}
		
		return -1;
	}
	
	static int getNthNodeFromEnd(Node head, int n) {
		
		if ( head == null || n <=0)
			return -1;
		
		Node slow = head;
		Node fast = head;
		
		for ( int i=1; i <= n; i++) {
			if ( fast == null)
				return -1;
			fast = fast.next;
		}
		
		while ( fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow.data;
	}
	
	static Node reverse(Node head) {
		
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		while ( curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	static void printList(Node node) {
		if ( head == null) {
			System.out.println("List is empty");
			return;
		}
			
		Node curr = node;
		while ( curr.next != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		
		System.out.println(curr.data);
	}

	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}
	
	static void add(int elem) {
		if ( head == null) {
			head = new Node(elem);
			return;
		}
		Node curr = head;
		
		while ( curr.next != null)
			curr = curr.next;
		curr.next = new Node(elem);
	}

}
