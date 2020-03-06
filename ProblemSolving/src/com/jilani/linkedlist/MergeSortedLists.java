package com.jilani.linkedlist;

public class MergeSortedLists {

	public static void main(String[] args) {

		
		LinkedList list1 = new LinkedList();
		//list1.insert(1);
		//list1.insert(3);
		list1.insert(5);
		
		LinkedList list2 = new LinkedList();
		list2.insert(2);
		list2.insert(4);
		list2.insert(7);
		
		list1.printList();
		list2.printList();
		Node merged = mergeLists(list1.head, list2.head);
		printList(merged);
	}

	private static void printList(Node head) {
		
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

	static Node mergeLists(Node head1, Node head2) {
		
		Node dummy = new Node(-1);
		Node tail = dummy;
		
		if ( head1 == null)
			return head2;
		
		if ( head2 == null)
			return head1;
		
		while ( head1 != null && head2 != null) {
			
			if ( head1.data <= head2.data) {
				tail.next = head1;
				head1 = head1.next;
				tail = tail.next;
			} else {
				tail.next = head2;
				head2 = head2.next;
				tail = tail.next;
			}
			
		}
		
		if (head1 == null)
			tail.next = head2;
		
		if ( head2 == null)
			tail.next = head1;
		
		return dummy.next;
	}
}
