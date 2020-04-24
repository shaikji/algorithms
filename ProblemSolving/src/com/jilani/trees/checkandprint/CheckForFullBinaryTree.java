package com.jilani.trees.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class CheckForFullBinaryTree {

	public static void main(String[] args) {

		root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(12);
		root.right.right = new Node(20);

		System.out.println(" Is perfect binary? " + isFullBinary(root));
		System.out.println(" Is perfect binary? " + isFullBinaryIterative(root));

	}

	static boolean isFullBinary(Node root) {

		if (root == null)
			return true;
		
		if ( root.left == null && root.right == null)
			return true;
		
		if ((root.left == null && root.right != null) || (root.right == null && root.left != null))
			return false;
		
		return isFullBinary(root.left) && isFullBinary(root.right);
	}
	
	static boolean isFullBinaryIterative(Node root) {
		
		if ( root == null)
			return true;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		Node node= null;
		
		while ( !queue.isEmpty()) {
			node = queue.poll();
			
			if (node.left == null && node.right == null)
				continue;
			if (node.left == null || node.right == null)
				return false;
			
			queue.add(node.left);
			queue.add(node.right);
				
		}
		return true;
	}

	// Checking in Pre order fashion
	// First check if root satisfies the condition
	// Then check the left & right sub trees

	static boolean checkUtil(Node root) {

		if (root == null)
			return true;

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
