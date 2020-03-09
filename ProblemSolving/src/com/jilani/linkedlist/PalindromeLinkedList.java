package com.jilani.linkedlist;

import java.util.Stack;

public class PalindromeLinkedList {

	public static void main(String[] args) {

		add(1);
		add(2);
		add(3);
		add(4);
		add(3);
		add(2);
		add(1);
		add(5);

		printList(head,"Original List");
		System.out.println(" isPalindrom = " + isPalindrome(head));
		System.out.println();
		printList(head,"After checking palindrome List");
		
		System.out.println();
		System.out.println(" isPalindrom = " + isPalindromeUsingStack(head));
		System.out.println();
		
		System.out.println();
		System.out.println(" isPalindrom = " + isPalindromeUsingRecursion(head));
		System.out.println();
		

	}
	
	

	private static boolean isPalindromeUsingRecursion(Node right) {
		
		left = head;
		
		if ( right == null)
			return true;
		
		boolean isp = isPalindromeUsingRecursion(right.next);
		
		if ( isp == false)
			return false;
		
		boolean isp2 = (left.data == right.data);
		
		left = left.next;
		
		return isp2;
	}



	private static boolean isPalindromeUsingStack(Node head) {
		
		// Find middle logic 
		
		if ( null == head || null == head.next) {
			return true;
		}
		
		Node slow = head;
		Node fast = head;
		Node prev = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while ( fast != null && fast.next != null) {
			stack.push(slow.data);
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node mid  = ( fast == null) ? prev: slow;
		
		mid = mid.next;
		
		while ( mid != null) {
			if ( mid.data != stack.pop()) {
				return false;
			}
			mid = mid.next;
		}
		
		return true;
	}

	static boolean isPalindrome(Node head) {

		if (head == null || head.next == null)
			return true;
		// Find middle
		Node mid = findMiddle(head);

		// Reverse the second half
		Node reverse = reverse(mid.next);
		mid.next = null;

		// Check if first half and second half are equal
		boolean result = checkForEquality(head, reverse);
		
		// restore the second half
		mid.next = reverse(reverse);
		
		// return result
		return result;
	}
	private static boolean checkForEquality(Node head, Node node) {
		Node curr = head;
		boolean result = true;
		while (node != null) {
			if (node.data != curr.data) {
				result = false;
				break;
			}
			node = node.next;
			curr = curr.next;
		}
		return result;
	}

	private static Node findMiddle(Node head) {
		
		Node slow = head;
		Node fast = head;
		Node mid = head;
		while (fast != null && fast.next != null) {
			mid = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return fast == null? mid: slow;
	}

	static Node reverse(Node node) {

		if (node == null || node.next == null)
			return node;

		Node curr = node;
		Node next = null;
		Node prev = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
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
	        
	        while ( head.next != null){
	            System.out.print(head.data+ " -> ");
	            head = head.next;
	        }
	        System.out.println(head.data);
	        System.out.println();
	    }
}
