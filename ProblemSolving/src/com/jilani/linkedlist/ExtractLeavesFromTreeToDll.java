package com.jilani.linkedlist;

import java.rmi.dgc.Lease;

public class ExtractLeavesFromTreeToDll {

	public static void main(String[] args) {
		
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(7);
		root.left.left.right = new Node(8);
		root.right.right = new Node(6);
		root.right.right.left = new Node(9);
		root.right.right.right = new Node(10);
		
		root = leafsToDll(root);
		printList(head," DLL after conversion");
		
	}
	
	// Optimized
	
	static Node leafsToDll(Node root) {
		
		if ( root == null)
			return null;
		
		if ( root.left == null && root.right == null) {
			
			if ( head == null) {
				head = root;
				tail = root;
			} else {
				tail.right = root;
				root.left = tail;
				tail = tail.right;
			}
			return null;
		}
		
		root.left = leafsToDll(root.left);
		root.right = leafsToDll(root.right);
		return root;
	}
	
	
	// First version - not very optimized.
	static void leafsToDll2(Node root) {
	
		if ( root == null)
			return;
		
		if ( root.right != null) {
			if ( root.right.left == null && root.right.right == null) {
				if ( head == null) {
					head = root.right;
					tail =head;
				} else {
					tail.right = root.right;
					root.right.left = tail;
					tail = tail.right;
				}
				root.right = null;
			}
		}
		
		if ( root.left != null) {
			if ( root.left.left == null && root.left.right == null) {
				if ( head == null) {
					head = root.left;
					tail =head;
				} else {
					tail.right = root.left;
					root.left.left = tail;
					tail = tail.right;
				}
				root.left = null;
			}
		}
		
		leafsToDll(root.right);
		leafsToDll(root.left);
		
	}

	
	static class Node{
		Node left;
		Node right;
		int data;
		
		Node( int data){
			this.data = data;
		}
	}
	
	static Node root, head, tail;
	
	static void printList(Node head, String message) {
		System.out.println(message);

		while (head.right != null) {
			System.out.print(head.data + " -> ");
			head = head.right;
		}
		System.out.println(head.data);
		System.out.println();
	}

}
