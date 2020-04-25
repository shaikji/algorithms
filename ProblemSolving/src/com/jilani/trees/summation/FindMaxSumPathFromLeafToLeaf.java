package com.jilani.trees.summation;

public class FindMaxSumPathFromLeafToLeaf {

	public static void main(String[] args) {

		root = new Node(-15);
		root.left = new Node(5);
		root.right = new Node(6);

		root.left.left = new Node(-8);
		root.left.right = new Node(1);
		root.right.left = new Node(3);
		root.right.right = new Node(9);

		root.left.left.left = new Node(2);
		root.left.left.right = new Node(6);
		
		root.right.right.right = new Node(0);
		
		root.right.right.right.left = new Node(4);
		root.right.right.right.right = new Node(-1);
		root.right.right.right.right.left = new Node(10);
		
		maxSumPathFromLeaftoLeaf(root);
		
		System.out.println(" Sum = " + maxsum );
	}
	
	
	static int maxSumPathFromLeaftoLeaf( Node root) {
		
		if ( root == null)
			return 0;
		
		int lsum  = maxSumPathFromLeaftoLeaf(root.left);
		int rsum = maxSumPathFromLeaftoLeaf(root.right);
		
		int sum = root.data + lsum + rsum;
		
		if ( maxsum < sum)
			maxsum = sum;
		
		return Math.max(lsum, rsum) + root.data;
	}
	
	static int maxsum = Integer.MIN_VALUE;

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
