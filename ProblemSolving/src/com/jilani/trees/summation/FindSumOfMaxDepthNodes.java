package com.jilani.trees.summation;

public class FindSumOfMaxDepthNodes {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		
		System.out.println(" Sum = " + maxDepthNodesSum(root));
	}
	
	static int maxDepthNodesSum(Node root) {
		
		if (root == null)
			return 0;
		
		int maxDepth = maxDepth(root);
		
		return sumNodes(root, maxDepth);
	}
	
	static int sumNodes(Node root, int max) {
		
		if ( root == null)
			return 0;
		
		if ( max == 1) {
			return root.data;
		}
		
		return sumNodes(root.left, max-1) + sumNodes(root.right, max-1);
	}
	
	static int maxDepth(Node root) {
		
		if ( root == null)
			return 0;
		
		int ld = maxDepth(root.left);
		int rd = maxDepth(root.right);
		
		return 1 + Math.max(ld, rd);
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
