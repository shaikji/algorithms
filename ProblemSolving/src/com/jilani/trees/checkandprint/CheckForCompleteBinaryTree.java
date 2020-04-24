package com.jilani.trees.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class CheckForCompleteBinaryTree {

	public static void main(String[] args) {

		root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(12);
		root.right.right = new Node(20);
		
		System.out.println(" Is complete binary? " + isComplete(root));
	}
	
	// Iterative
	static boolean isComplete ( Node root) {
		
		if ( root == null)
			return true;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node node = null;
		boolean foundLeaf = false;
		
		while ( !queue.isEmpty()) {
			node = queue.poll();
			
			// Property check
			if ( node.right != null && node.left == null )
				return false;
			
			// Leaf Node
			if ( node.left == null && node.right == null) {
				if ( !foundLeaf)
					foundLeaf = true;
				
			// Internal Node
			} else if ( node.left == null || node.right == null) {
				if ( foundLeaf )
					return false;
			}
			
			if ( null != node.left)
				queue.add(node.left);
			
			if ( null != node.right)
				queue.add(node.right);
			
		}
		
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
