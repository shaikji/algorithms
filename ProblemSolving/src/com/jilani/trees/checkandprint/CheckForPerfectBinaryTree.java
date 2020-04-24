package com.jilani.trees.checkandprint;

public class CheckForPerfectBinaryTree {

	public static void main(String[] args) {

		root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(12);
		root.right.right = new Node(20);
		
		System.out.println(" Is perfect binary? " + check(root));
	}

	static boolean check(Node root) {

		if (root == null)
			return true;

		return checkUtil(root,0);
	}
	
	static int levelOfLeaf = -1;

	// Checking in Pre order fashion
	// First check if root satisfies the condition
	// Then check the left & right sub trees
	
	static boolean checkUtil(Node root, int level) {
		
		if ( root == null)
			return true;
		
		if ( (root.left == null && root.right != null) || 
				(root.right == null && root.left != null) ) {
			return false;
		}
		if ( root.left == null && root.right == null) {
			if ( levelOfLeaf == -1 ) {
				levelOfLeaf = level;
			} else {
				if ( levelOfLeaf != level)
					return false;
			}
		}
		
		boolean left = checkUtil (root.left, level + 1);
		if (!left)
			return false;
		
		boolean right = checkUtil(root.right, level + 1);
		if ( !right )
			return false;
		
		return true;
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
