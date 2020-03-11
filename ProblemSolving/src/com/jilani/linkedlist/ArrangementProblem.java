package com.jilani.linkedlist;

// Arrange the list L0 L1 L2 L3 L4 .. Ln-1 Ln into
// L0 Ln L1 Ln-1 L2 Ln-3 .....

public class ArrangementProblem {

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++)
			add(i);

		printList(head, "Original List");
		//head = rearrange(head);
		rearrangeRecursive(head);
		printList(head, "List after re-arrangement");
	}

	
	static boolean rearrangeRecursive ( Node right) {
		
		if ( right == null)
			return false;
		
		left = head;
		
		boolean ret = rearrangeRecursive(right.next);
		
		if ( ret == true)
			return true;
		
		if ( left == right || left.next == right) {
			 right.next = null;
			return true;
		}
		
		Node temp = left.next;
		left.next = right;
		right.next = temp;
		left = temp;
		return false;
	}
	static Node rearrange(Node head) {

		if (head == null || head.next == null)
			return head;

		Node middle = findMiddle(head);
		Node second = middle.next;
		
		middle.next = null;

		middle = reverse(second);

		Node currX = head;
		Node currY = middle;
		Node nextX = null;
		Node nextY = null;

		while (currY != null) {
			nextX = currX.next;
			nextY = currY.next;
			currX.next = currY;
			currY.next = nextX;
			currX = nextX;
			currY = nextY;
		}

		return head;

	}
	
	private static Node reverse(Node head) {
		if ( head == null)
			return head;
		
		Node curr = head;
		Node next = null;
		Node prev = null;
		
		while ( curr != null ) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	private static Node findMiddle(Node head) {
		if ( head == null )
			return head;
		
		Node slow =head;
		Node fast = head;
		Node prev = null;
		
		while ( fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if ( fast == null)
			return prev;
		return slow;
				
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static Node head;
	static Node left;

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
