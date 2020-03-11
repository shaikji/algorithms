package com.jilani.linkedlist;

public class AddTwoNumbersRepresentedByLists {

	public static void main(String[] args) {

		/*
		Node num1 = new Node(7);
		num1.next = new Node(5);
		num1.next.next = new Node(9);
		num1.next.next.next = new Node(4);
		num1.next.next.next.next = new Node(6);

		printList(num1, "List1");

		Node num2 = new Node(8);
		num2.next = new Node(4);

		printList(num2, "List2");

		Node result = addNumbers(num1, num2);

		printList(result, "Sum List");
		
		*/
		
		
		Node num1 = new Node(5);
		num1.next = new Node(6);
		num1.next.next = new Node(3);

		printList(num1, "List1");

		Node num2 = new Node(8);
		num2.next = new Node(4);
		num2.next.next = new Node(2);

		printList(num2, "List2");

		Node result = addNumbers(num1, num2);

		printList(result, "Sum List");

	}

	static Node addNumbers(Node num1, Node num2) {

		if (num1 == null)
			return num2;
		if (num2 == null)
			return num1;

		Node p = num1;
		Node q = num2;
		int sum = 0;
		int num = 0;
		int carry = 0;
		Node dummy = new Node(-1);
		Node tail = dummy;

		while (p != null && q != null) {

			sum = carry + p.data + q.data;
			num = sum % 10;
			carry = sum / 10;
			tail.next = new Node(num);
			tail = tail.next;
			p = p.next;
			q = q.next;
		}

		while (p != null) {

			sum = carry + p.data;
			num = sum % 10;
			carry = sum/10;
			tail.next = new Node(num);
			tail = tail.next;
			p = p.next;
		}

		while (q != null) {

			sum = carry + q.data;
			num = sum % 10;
			carry = sum / 10;
			tail.next = new Node(num);
			tail = tail.next;
			q = q.next;
		}
		
		if ( carry == 1) {
			tail.next = new Node(carry);
		}

		return dummy.next;
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
