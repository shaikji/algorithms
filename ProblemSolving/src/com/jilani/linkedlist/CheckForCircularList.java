package com.jilani.linkedlist;

public class CheckForCircularList {

	public static void main(String[] args) {

		
		Node num1 = new Node(1);
		num1.next = new Node(2);
		num1.next.next = new Node(3);
		num1.next.next.next = new Node(4);
		num1.next.next.next.next = num1;
		
		System.out.println(" isCircular = " + isCircular(num1));
		System.out.println(" isCircular = " + isCircular(null));
		System.out.println(" isCircular = " + isCircular(new Node(1)));
		Node num2 = new Node(1);
		System.out.println(" isCircular = " + isCircular(num2));
		
		Node num3 = new Node(1);
		num3.next = num3;
		System.out.println(" isCircular = " + isCircular(num3));
	}
	
	static boolean isCircular(Node head) {
		if ( head == null)
			return true;
		
		Node node = head.next;
		
		while ( node != head) {
			if ( node == null)
				return false;
			node = node.next;
		}
		
		return true;
	}
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
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
