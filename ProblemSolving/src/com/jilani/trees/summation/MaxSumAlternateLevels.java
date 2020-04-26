package com.jilani.trees.summation;

// Note: The below code works also for duplicates because, in the map we are using Node as the key and not the value.

public class MaxSumAlternateLevels {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(1);
		root.right.left = new Node(4);
		root.right.right = new Node(5);

		System.out.println(" Sum = " + maxSum(root));
	}
	
	static int maxSum(Node root) {
		
		if ( root == null)
			return 0;
		
		return Math.max(maxAltLevelSum(root), maxAltLevelSum(root.left) + maxAltLevelSum(root.right));
	}
	
	static int maxAltLevelSum(Node root) {
		
		if (root == null) {
			return 0;
		}
		
		int sum = root.data;
		
		if ( root.left != null) {
			sum += maxAltLevelSum(root.left.left);
			sum += maxAltLevelSum(root.left.right);
		}
		
		if ( root.right != null) {
			sum += maxAltLevelSum(root.right.left);
			sum += maxAltLevelSum(root.right.right);
		}
		
		return sum;
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
