package com.jilani.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class UnionIntersection {

	public static void main(String[] args) {
		
		LinkedList list1 = new LinkedList();
		list1.insert(1);
		list1.insert(2);
		list1.insert(3);
		list1.insert(4);
		
		LinkedList list2 = new LinkedList();
		list2.insert(3);
		list2.insert(4);
		list2.insert(5);
		list2.insert(6);

		//LinkedList unionList = union(list1,list2);
		//unionList.printList();
		
		LinkedList intersection = intersection(list1, list2);
		intersection.printList();

	}

	static LinkedList union(LinkedList list1, LinkedList list2) {
		LinkedList union = new LinkedList();
		
		Set<Integer> set = new HashSet();
		
		Node current = list1.head;
		
		while ( current != null) {
			
			if ( !set.contains(current.data)) {
				union.insert(current.data);
				set.add(current.data);
			}
			current = current.next;
		}
		
		current = list2.head;
		
		while ( current != null) {
			
			if ( !set.contains(current.data)) {
				union.insert(current.data);
				set.add(current.data);

			}
			current = current.next;
		}
		
		return union;
	}
	
	static LinkedList intersection(LinkedList list1, LinkedList list2) {
		LinkedList intersection = new LinkedList();
		
		Set<Integer> set = new HashSet();
		
		Node current = list1.head;
		
		while ( current != null) {
			
			if ( set.contains(current.data)) {
				intersection.insert(current.data);
			}
			set.add(current.data);
			current = current.next;
		}
		
		current = list2.head;
		
		while ( current != null) {
			
			if ( set.contains(current.data)) {
				intersection.insert(current.data);
			}
			set.add(current.data);
			current = current.next;
		}
		
		return intersection;
	}

}
