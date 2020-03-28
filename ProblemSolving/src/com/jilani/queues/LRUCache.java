package com.jilani.queues;

import java.util.HashMap;

public class LRUCache {
	
	HashMap<Integer, Node> map;
	int cache_size;
	
	LRUCache(int cache_size){
		this.cache_size = cache_size;
		head = tail = null;
		map = new HashMap();
	}
	
	
	public void refer ( int x) {
		
		
	}
	
	static Node head;
	static Node tail;
	
	static class Node{
		int data;
		Node next;
		Node prev;
		Node ( int data){
			this.data = data;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
