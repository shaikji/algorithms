package com.jilani.trees.checkandprint;

public class CheckForChildrenSum {

	public static void main(String[] args) {

		root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(12);

		System.out.println(" Is children sum property satisfied? " + check(root));
	}

	static boolean check(Node root) {

		if (root == null)
			return true;

		return checkUtil(root);
	}

	// Checking in Pre order fashion
	// First check if root satisfies the condition
	// Then check the left & right sub trees
	
	static boolean checkUtil(Node root) {
		
		if ( root == null || (root.left == null && root.right == null)) {
			return true;
		}
		
		int left_data =0;
		int right_data = 0;
		
		if ( root.left != null)
			left_data = root.left.data;
		
		if ( root.right != null)
			right_data = root.right.data;
		
		if ((root.data == left_data + right_data) && checkUtil(root.left)
				&& checkUtil(root.right) )
		return true;
		else
			return false;
		
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
