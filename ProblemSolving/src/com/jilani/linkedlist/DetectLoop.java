package com.jilani.linkedlist;

public class DetectLoop {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		
		list.printList();
		System.out.println(" Loop exists = " + list.loopExists());

		list.makeALoop();
		System.out.println(" Loop exists = " + list.loopExists());

	}

}
