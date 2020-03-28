package com.jilani.queues;

import java.util.HashMap;

public class LRUCache {

	HashMap<Integer, Node> map;
	int capacity;

	LRUCache(int capacity) {
		this.capacity = capacity;
		head = tail = null;
		map = new HashMap<Integer, Node>(capacity);
	}

	public int get(int key) {
		
		int result = -1;
		
		Node node = map.get(key);
		
		if ( node != null) {
			remove(node);
			add(node);
			result = node.value;
		}
		
		return result;
	}

	public void put(int key, int value) {

		Node node = map.get(key);
		
		if ( node != null) {
			remove(node);
			node.value = value;
			add(node);
		} else {
			node = new Node(key, value);
			if ( isCacheFull()) {
				map.remove(tail.key);
				remove(tail);
			}
			// add Node
			add(node);
		}
		map.put(key, node);
		
	}

	private boolean isCacheFull() {
		return map.size() == capacity;
	}
	
	// Adds a node to the DLL
	private void add(Node node) {
		// Add node to the head
		if ( head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
	}
	
	// Removes a node from DLL
	private void remove(Node node) {
		
		if ( head == null)
			return;
		
		if ( head == node) {
			if ( head == tail )
				tail = tail.next;
			head = head.next;
		} else {
			node.prev.next = node.next;
			if ( node.next != null)
				node.next.prev = node.prev;
			else
				tail = node.prev;
		}		
		
	}
	
	void printDLL() {
		
		Node node = head;
		while ( node != null) {
			System.out.print("("+node.key+","+node.value+")" + " -> ");
			node = node.next;
		}
		System.out.println();
	}
	
	 void printMap() {
		
		for ( int key: map.keySet()) {
			System.out.print(key + ":"+ map.get(key).value+ " , ");
		}
		System.out.println();
	}
	 
	 void printStats() {
		 System.out.println();
		 printMap();
		 printDLL();
		 System.out.println();
	 }

	static Node head;
	static Node tail;

	static class Node {
		int key;
		int value;
		Node next;
		Node prev;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	

	public static void main(String[] args) {

		LRUCache cache = new LRUCache(5);
		
		cache.printStats();

		cache.put(1, 10);
		cache.printStats();
		cache.get(1);
		cache.printStats();
		
		cache.put(2, 20);
		cache.printStats();

		
		cache.put(3, 30);
		cache.printStats();

		cache.put(4, 40);
		cache.printStats();

		
		cache.put(5, 50);
		cache.printStats();

		
		cache.put(6, 60);
		cache.printStats();

		cache.get(4);
		cache.printStats();
		
		cache.get(2);
		cache.printStats();


	}

}
