package com.jilani.trees.checkandprint;

import java.util.HashSet;

public class CheckForDuplicates {

	public static void main(String[] args) {

		root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(12);

		System.out.println(" hasDuplicates? " + hasDuplicates(root));
	}

	static boolean hasDuplicates(Node root) {

		if (root == null)
			return false;

		HashSet<Integer> set = new HashSet();
		return checkUtil(root, set);
	}

	// Checking in Pre order fashion
	// First check if root satisfies the condition
	// Then check the left & right sub trees
	
	static boolean checkUtil(Node root, HashSet<Integer> set) {
		
		if (root == null)
			return false;
		
		if ( set.contains(root.data))
			return true;
		
		set.add(root.data);
		
		return checkUtil(root.left, set) || checkUtil(root.right, set);
		
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
