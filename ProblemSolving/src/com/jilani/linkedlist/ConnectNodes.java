package com.jilani.linkedlist;

public class ConnectNodes {

	public static void main(String[] args) {
		
		LinkedList pList = new LinkedList();
		pList.insert(1);
		pList.insert(2);
		pList.insert(3);
		pList.insert(4);
		pList.insert(5);
		pList.insert(6);
		
		pList.printList();
		
		LinkedList qList = new LinkedList();
		qList.insert(11);
		qList.insert(22);
		qList.insert(33);
		qList.insert(44);
		qList.insert(55);
		qList.insert(66);
		
		qList.printList();
		
		/*
		 * LinkedList rList = connectNodes(pList, qList); rList.printList();
		 */
	}

	private static Node connectNodes(LinkedList first, LinkedList second) {
		
		Node pNode = first.head;
		Node qNode = second.head;
		
		Node pNext = null;
		Node qNext = null;
		
		while ( pNode!= null && qNode != null) {
			
			pNext = pNode.next;
			qNext = qNode.next;
			
			pNode.next = qNode;
			qNode.next = pNext;
			
			pNode = pNext;
			qNode = qNext;
		}
		
		return pNode;
		
	}

}
