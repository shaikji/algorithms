package com.jilani.linkedlist;

public class SortAlternativeAscDescList {

	public static void main(String[] args) {
		
		add(10);
		add(40);
		add(53);
		add(30);
		add(67);
		add(12);
		add(89);
		
		// sort this list which every alternate node is ascending 
		// the other alternate node is descending
		
		printList(head, " Original List");
		sort(head);
		printList(head, " Sorted List");
		
	}
	
	
	
	// Modular
	
	static void sort( Node head) {
		
		if ( head == null || head.next == null)
			return;
		
		// Now split the nodes into two
		
		Node AList = new Node(-1);
		Node BList = new Node(-2);
		
		splitLists(head, AList, BList);
		
		AList = AList.next;
		BList = BList.next;
		
		BList = reverse(BList);
		
		//mergeLists(AList, BList);
		// Recursive
		mergeListsRec(AList, BList);
	}
	
	
	// Both lists are sorted.

	
	static Node mergeListsRec(Node p, Node q) {
		
		if ( p == null)
			return q;
		if ( q == null)
			return p;
		
		Node temp = null;
		
		if ( p.data <= q.data ) {
			p.next = mergeListsRec(p.next, q);
			temp = p;
		}
		else {
			q.next = mergeListsRec(p, q.next);
			temp = q;
		}
		
		return temp;
	}
	static Node mergeLists(Node p, Node q) {
		
		
		Node dummy = new Node(-1);
		Node tail = dummy;
		
		Node pNext = null;
		Node qNext = null;
		
		while ( p != null && q != null) {

			pNext = p.next;
			qNext = q.next;
			
			if ( p.data <= q.data) {
				tail.next = p;
				p = pNext;
			} else {
				tail.next = q;
				q = qNext;
			}
			tail = tail.next;
		}
		
		if ( p == null)
			tail.next = q;
		if ( q == null)
			tail.next = p;
		
		return dummy.next;
		
			
	}
	static Node reverse ( Node head) {
		
		if ( head == null)
			return head;
		
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
	
	static void splitLists( Node head, Node aNode, Node bNode) {
		Node curr = head;
		
		while ( curr != null) {
			aNode.next = curr;
			aNode = aNode.next;
			curr = curr.next;
			
			if ( curr != null) {
				bNode.next = curr;
				bNode = bNode.next;
				curr = curr.next;
			}
		}
		
		aNode.next = null;
		bNode.next = null;
	}
	
	// A better version is coded above
	
	static void sortV2(Node head) {
		
		if ( head == null || head.next == null)
			return;
		
		Node curr = head;
		Node prev = null;
		Node head2 = null;
		Node next = null;
		
		while ( curr != null && curr.next != null) {
			
			next = curr.next;
			prev = curr;
			curr.next = curr.next.next;
			if ( head2 == null ) {
				head2 = next;
				next.next = null;
			} else {
				next.next = head2;
				head2 = next;
			}
			curr = curr.next;
		}
		
		if ( curr != null) {
			prev.next = curr;
			prev = curr;
		}
		
		prev.next = head2;
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
