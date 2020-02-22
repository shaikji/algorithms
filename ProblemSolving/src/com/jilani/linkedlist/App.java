package com.jilani.linkedlist;

public class App {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		for ( int i=1; i <= 10; i++) {
			list.insert(i);
		}
		
		System.out.println(" Original List");
		list.printList();
		int k=1;
		
		list.reverseInGroupsOfK(k);
		System.out.println(" after reverse in groups of " + k);
		list.printList();

	}

}
