package com.jilani.linkedlist;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		
		list.printList();
		
		list.removeDuplicates();
		
		list.printList();
		

	}

}
