package com.jilani.trees.checkandprint;

import java.util.HashSet;

public class CheckForDuplicateSubTrees {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(2);
		root.right.right.left = new Node(4);
		root.right.right.right = new Node(5);
		

		System.out.println(" hasDuplicates? " + hasDuplicatesSubtrees(root));
	}

	static boolean hasDuplicatesSubtrees(Node root) {
		if ( root == null)
			return false;
		HashSet<String> set = new HashSet();
		
		return hasDups(root, set) == "";
	}
	
	static String hasDups(Node root, HashSet<String> set) {
	
		String s ="";
		
		if (root == null)
			return "#";
		
		String left = hasDups(root.left, set);
		if ( left == "")
			return "";
		
		String right = hasDups(root.right, set);
		if ( right == "")
			return "";

		s = root.data + left + right;
		
		if (s.length() > 3 && set.contains(s))
			return "";
		
		set.add(s);
		return s;
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
