package com.jilani.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
	
	Node head = null;
	
	void insert(int data) {
		
		Node node = new Node(data);
		
		if ( head == null) {
			head = node;
			return;
		}
		
		Node curr = head;
		
		while ( curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = node;
	}
	
	
	void printList () {
		
		if ( head == null) {
			System.out.println(" List is empty");
			return;
		}
		
		Node curr = head;
		
		while ( curr.next != null) {
			System.out.print( curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}
	
	void printMiddle() {
		
		if ( head == null) {
			System.out.println("List is empty - no middle element");
			return;
		}
		
		Node slow = head;
		Node fast = head.next;
		
		while ( fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		System.out.println(" Middle of the list = " + slow.data);
	}
	
	
	void reverseInGroupsOfK( int k) {
		
		head = reverseInGroupsOfK(head, k);
		
	}


	private Node reverseInGroupsOfK(Node head, int k) {
		
		Node prev = null;
		Node next = null;
		Node curr = head;
		
		int count = 0;
		
		while ( count < k && curr != null ) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		
		if ( next != null)
			head.next = reverseInGroupsOfK(next, k);
		
		return prev;
	}
	
	public int findNthFromLast(int n) {
		
		Node first = null;
		Node last = head;
		
		while ( last != null) {
			
			if ( n == 0 ) {
				first = head;
			}
			
			n--;
			if ( first != null )
				first = first.next;
			last = last.next;

		}
		
		if ( n == 0 )
			first = head;

		return first == null ? -1: first.data;
	}
	
	public int findNthFromLastV2(int n ) {
		
		if ( head == null || n <= 0)
			return -1;
		
		int count = 0;
		Node p = head;
		Node q = head;
		
		while ( count < n) {
			
			if ( q == null ) {
				return -1;
			}
			count++;
			q = q.next;
		}
		
		while ( q != null ) {
			p = p.next;
			q = q.next;
		}
		
		return p.data;
	}


	public void removeDuplicates() {
		
		if ( head == null)
			return;
		
		Set<Integer> set = new HashSet<Integer>();
		
		Node curr = head;
		Node prev = null;
		
		while ( curr != null) {
			
			if (set.contains(curr.data)) {
				prev.next = curr.next;
				curr = curr.next;
			} else {
				set.add(curr.data);
				prev = curr;
				curr = curr.next;
			}
		}
	}
 
}
