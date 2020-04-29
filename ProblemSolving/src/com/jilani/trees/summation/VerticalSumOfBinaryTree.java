package com.jilani.trees.summation;

import java.util.ArrayList;
import java.util.HashMap;

public class VerticalSumOfBinaryTree {

	public static void main(String[] args) {
		
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
	
		printVerticalSums(root);
		System.out.println();
		printVerticalSumV2(root);
	}
	
	static class DLLNode {
		
		int data;
		DLLNode prev;
		DLLNode next;
		
		DLLNode(int data){
			this.data = data;
		}
	}
	
	static void printVerticalSumV2(Node root) {
		
		
		if ( root == null)
			return;
		
		DLLNode dnode = new DLLNode(0);
		printUtil(root, dnode);
		
		
		while ( dnode.prev != null) {
			dnode = dnode.prev;
		}
		
		while ( dnode != null) {
			System.out.println(dnode.data);
			dnode = dnode.next;
		}
		
	}

	
	static void printUtil(Node root, DLLNode dnode) {

		dnode.data += root.data;
		
		if ( root.left != null) {
			if ( dnode.prev == null) {
				DLLNode tnode = new DLLNode(0);
				tnode.next = dnode;
				dnode.prev = tnode;
			}
			printUtil(root.left, dnode.prev);
		}
		
		if ( root.right != null) {
			if ( dnode.next == null) {
				DLLNode tnode = new DLLNode(0);
				dnode.next = tnode;
				tnode.prev = dnode;
			}
			printUtil(root.right, dnode.next);
		}
		
	}
	
	static void printVerticalSums( Node root) {
	
		if ( root == null)
			return;
		
		HashMap<Integer, Integer> map = new HashMap();
		
		printPathsUtil(root, map, 0);
		
		for (int hd: map.keySet()) {
			System.out.println(hd +" => " + map.get(hd));
		}
	}
	
	static void printPathsUtil(Node root, HashMap<Integer, Integer> map, int hd) {
	
		if( root == null) {
			return;
		}
		
		map.put(hd, map.getOrDefault(hd, 0) + root.data);
		
		printPathsUtil(root.left, map, hd-1);
		printPathsUtil(root.right, map, hd+1);
	}
	
	static void print(ArrayList<Integer> path) {
		System.out.println(path);
	}
			
	static Node root;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	

}
