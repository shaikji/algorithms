package com.jilani.linkedlist;

import java.util.Stack;

//https://www.geeksforgeeks.org/modify-contents-linked-list/

public class ModifyListNodeValue {

	public static void main(String[] args) {

		/*
		 * add(10); add(4); add(5); add(3); add(6);
		 */

		// 2 -> 9 -> 8 -> 12 -> 7 -> 10

		add(2);
		add(9);
		add(8);
		add(12);
		add(7);
		add(10);

		printList(head, "Before Modification");
		// modifyContentsV1(head);
		// modifyContentsV2(head);
		modifyContentsV3(head);
		printList(head, "After Modification");

	}

	// Version 1 Implementation
	// Use Recursion ( left, right ) and modify

	static boolean modifyContentsV1(Node right) {

		if (right == null)
			return false;

		left = head;
		boolean res = modifyContentsV1(right.next);

		if (res)
			return res;

		if (left == right) {
			return true;
		}

		left.data = left.data - right.data;

		if (left.next == right)
			return true;
		left = left.next;
		return false;
	}

	// Version 2 Implemenation
	// Find the middle point
	// Split the lists
	// reverse the second half
	// traverse both the lists and do the processing/modification
	// Again reverse the second list
	// Weave to return the final list
	static void modifyContentsV2(Node head) {

		if (head == null)
			return;

		Node mid = findMiddle(head);
		Node second = mid.next;
		mid.next = null;

		second = reverse(second);

		Node currX = head;
		Node currY = second;

		while (currY != null) {
			currX.data = currX.data - currY.data;
			currX = currX.next;
			currY = currY.next;
		}
		mid.next = reverse(second);
	}

	// Version 3 Implementation
	// Find midPoint
	// From next of MidPoint till end store the nodes in stack
	// Now while stack is not empty, modify the contents of the list from start

	static void modifyContentsV3(Node head) {
		if (head == null)
			return;

		Stack<Integer> stack = new Stack();
		Node mid = findMiddle(head);

		Node curr = mid.next;
		while (curr != null) {
			stack.push(curr.data);
			curr = curr.next;
		}

		curr = head;
		while (!stack.isEmpty()) {
			curr.data = curr.data - stack.pop();
			curr = curr.next;
		}
	}

	static Node reverse(Node head) {
		if (head == null)
			return head;

		Node curr = head;
		Node prev = null;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	static Node findMiddle(Node head) {

		if (head == null)
			return head;

		Node prev = null;
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		return (fast == null) ? prev : slow;
	}

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static Node head, left;

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
