package com.jilani.trees.summation;

public class CheckForRootToLeafPathWithTheGivenSum {

	public static void main(String[] args) {
		
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);

		int K = 8;
		System.out.println("hasSum "+ K + " = " + hasSum(root,  K, 0));
		System.out.println("hasPathSum "+ K + " = " + hasPathSum(root,  K));
	}
	
	static boolean hasSum ( Node root, int K, int sum ) {
		
		if ( root == null)
			return false;
		
		sum += root.data;
		
		if ( root.left == null && root.right == null) {
			return sum == K; 
		}
		
		return hasSum(root.left, K, sum) || hasSum(root.right, K, sum);
	}
	
	
	static boolean hasPathSum(Node root, int sum) {
		
		if ( root == null)
			return sum == 0;
		
		return hasPathSum(root.left, sum-root.data) || hasPathSum(root.right, sum-root.data);
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
