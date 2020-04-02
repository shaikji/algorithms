package com.jilani.practice.linkedlists;

import java.util.Stack;

public class CheckForPalindromeList {

	public static void main(String[] args) {

		CheckForPalindromeList list = new CheckForPalindromeList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);
		list.add(1);
		System.out.println(" Is List Palindrome? = " + isPalindrome(head));
		System.out.println(" Is List Palindrome Rec? = " + isPalinRec(head));
		System.out.println(" Is List Palindrome Rec? = " + isPalinV2(head));

	}
	
	static Node left;
	
	static boolean isPalinRec( Node node) {
		
		if ( node == null)
			return true;
		
		left = head;
		
		boolean isp1 = isPalinRec(node.next);
		if ( !isp1 )
			return isp1;
		
		if ( left.data != node.data)
			return false;
		left = left.next;
		return true;
	}
	
	
	static boolean isPalinV2 ( Node head) {
		
		if ( head == null)
			return true;
		
		// Step 1: Find Middle of the list
		
		Node mid = findMiddle(head);
		
		Node reverse = reverse(mid.next);
		
		Node node = reverse;
		Node curr = head;
		
		boolean isPalindrome = true;
	
		while ( node != null) {
			if ( node.data != curr.data) {
				isPalindrome = false;
				break;
			}
			curr = curr.next;
			node = node.next;
		}
		
		// restore list
		mid.next = reverse(reverse);
		
		// 1 2 2 1  => 1 2 1 2 
		// 1 2 3 2 1 => 1 2 3 1 2 
		
		return isPalindrome;
		
	}
	
	static Node reverse(Node head) {
		if ( head == null)
			return head;
		
		Node curr = head;
		Node next = null;
		Node prev = null;
		
		while ( curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
	
	static Node findMiddle(Node head) {
		if ( head == null || head.next == null)
			return head;
		
		Node curr = head;
		Node fast = head;
		
		while ( fast != null && fast.next != null) {
			curr = curr.next;
			fast = fast.next.next;
		}
		return curr;
	}

	static boolean isPalindrome(Node head) {
		if (head == null)
			return true;

		Node slow = head;
		Node fast = head;
		Node prev = null;
		Stack<Integer> stack = new Stack();
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null)
			slow = slow.next;

		while (slow != null) {
			if (slow.data != stack.pop())
				return false;
			slow = slow.next;
		}

		return true;

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
		Node node = new Node(elem);
		if (head == null) {
			head = node;
			return;
		}

		Node curr = head;
		while (curr.next != null)
			curr = curr.next;
		curr.next = node;
	}

}
