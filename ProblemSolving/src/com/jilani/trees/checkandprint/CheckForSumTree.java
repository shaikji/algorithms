package com.jilani.trees.checkandprint;

public class CheckForSumTree {

	public static void main(String[] args) {

		root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(3);

		System.out.println(" SumTree =  " + isSumTree(root));
	}


	// Checking in Pre order fashion
	// First check if root satisfies the condition
	// Then check the left & right sub trees
	
	static boolean isSumTree(Node root) {
		
		if ( root == null || isLeaf(root)) {
			return true;
		}
		int ls;
		int rs;
		
		if ( isSumTree(root.left) && isSumTree(root.right)) {
			
			if ( root.left == null)
				ls = 0;
			else if ( isLeaf(root.left)) {
				ls = root.left.data;
			} else {
				ls = 2 * root.left.data;
			}
			
			
			if ( root.right == null)
				rs = 0;
			else if ( isLeaf(root.right)) {
				rs = root.right.data;
			} else {
				rs = 2 * root.right.data;
			}
			
			return root.data ==  ( ls + rs);
		}
		
		return false;
		
	}
	
	static boolean isLeaf(Node node) {
		if ( node.left == null && node.right == null)
			return true;
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
