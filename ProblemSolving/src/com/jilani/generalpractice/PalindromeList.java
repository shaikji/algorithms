package com.jilani.generalpractice;

import java.util.Stack;

public class PalindromeList {

	public static void main(String[] args) {

		add(1);
		add(2);
		add(3);
		//add(4);
		add(3);
		add(2);
		add(1);
		 //add(2);

		System.out.println(" isPalindrome using Reversing Technique = " + isPalindrome(head));
		System.out.println(" isPalindrome using Stack = " + isPalindromeUsingStack(head));
		System.out.println(" isPalindrome using Recursion = "+ isPalindromeUsingRecursion(head));
	}
	
	static boolean isPalindromeUsingRecursion( Node right) {
	
		//  1 (l) 2 3 2 1(r) 
		
		left = head;
		
		if ( right == null) {
			return true;
		}
		
		boolean isp = isPalindromeUsingRecursion(right.next);
		
		if ( !isp )
			return false;
		
		boolean isp2 = (left.data == right.data);
		left = left.next;
		
		return isp2;
	}
	
	

	static boolean isPalindromeUsingStack(Node head) {

		Stack<Integer> stack = new Stack();

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		Node second = slow;

		if (fast != null)
			second = slow.next;

		while (second != null) {
			if (second.data != stack.pop()) {
				return false;
			}
			head = head.next;
			second = second.next;
		}
		return true;
	}

	static boolean isPalindrome(Node head) {

		/*
		 * 1. Get Middle of the node 2. Reverse the second half 3. Check for equality 4.
		 * Restore the list 5. Return the result
		 */

		if (head == null || head.next == null) {
			return true;
		}

		// 1. Get the middle
		Node mid = findMiddle(head);

		// 2. Reverse the second half

		Node reverse = reverse(mid.next);

		mid.next = reverse;

		boolean equal = isEqual(head, mid.next);

		// Restore the list
		mid.next = reverse(mid.next);

		return equal;
	}

	static boolean isEqual(Node first, Node second) {

		while (second != null) {
			if (second.data != first.data) {
				return false;
			}
			first = first.next;
			second = second.next;
		}
		return true;
	}

	static Node reverse(Node head) {

		Node curr = head;
		Node prev = null;
		Node next = null;

		while (curr != null) {
			// store the next pointer
			next = curr.next;
			// Linking
			curr.next = prev;

			// For the next loop
			prev = curr;
			curr = next;
		}

		// 1 -> 2 -> 3 -> 4
		// curr - 1, prev - null, next -> 2
		return prev;

	}

	static Node findMiddle(Node head) {

		Node slow = head;
		Node fast = head;
		Node prev = head;

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

		Node node = new Node(data);
		if (head == null) {
			head = node;
			return;
		}

		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = node;
	}
}
