package com.jilani.linkedlist;

public class MergeSortALinkedList {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		/*
		 * list.insert(5); list.insert(4); list.insert(3); list.insert(2);
		 * list.insert(1);
		 */
		
		list.insert(1);
		list.insert(3);
		list.insert(2);
		list.insert(4);
		list.insert(5);

		list.printList();
		Node head = mergeSort(list.head);

		printList(head);
	}

	static Node mergeSort(Node head) {
		
		if ( head == null || head.next == null) {
			return head;
		}
		
		Node middle = getMiddle(head);
		Node nextOfMiddle = middle.next;
		
		middle.next = null;
		
		Node left = mergeSort(head);
		Node right = mergeSort(nextOfMiddle);
		
		Node sortedList = sortedMerge(left, right);
		
		return sortedList;
		
	}
	
	static Node sortedMerge( Node left, Node right) {
		
		
		Node dummy = new Node(-1);
		Node tail = dummy;
		
		while ( left != null && right != null) {
			
			if ( left.data <= right.data) {
				tail.next = left;
				left = left.next;
				tail = tail.next;
			} else {
				tail.next = right;
				right = right.next;
				tail = tail.next;
			}
		}
		
		if ( left != null) {
			tail.next = left;
		}
		
		if ( right != null) {
			tail.next = right;
		}
		
		return dummy.next;
	}
	
	
	static Node getMiddle ( Node head) {
		
		if ( head == null || head.next == null) {
			return head;
		}
		
		Node slow = head;
		Node fast = head;
		Node prev = null;
		
		while ( fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return prev;
	}

	private static void printList(Node head) {

		if (head == null) {
			System.out.println(" List is empty");
			return;
		}

		Node curr = head;

		while (curr.next != null) {
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}

}
