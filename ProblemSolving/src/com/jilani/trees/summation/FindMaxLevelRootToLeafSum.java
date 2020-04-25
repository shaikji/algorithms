package com.jilani.trees.summation;

public class FindMaxLevelRootToLeafSum {

	public static void main(String[] args) {

		root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);

		root.left.left = new Node(7);
		root.left.right = new Node(1);
		root.right.left = new Node(2);
		root.right.left = new Node(3);
		
		root.left.right.left = new Node(6);
		
		System.out.println(" Sum = " + maxLevelRootToLeafSum(root));
	}
	
	static int maxLevel = Integer.MIN_VALUE;
	static int sum =Integer.MIN_VALUE;
	
	static int maxLevelRootToLeafSum( Node root) {
		
		if ( root == null)
			return 0;
		
		maxLevelSum(root, 0, 0);
		
		return sum;
	}
	
	static void maxLevelSum ( Node root, int currSum, int level) {
		
		if ( root == null)
			return;
		

		currSum += root.data;
		
		if ( level > maxLevel ) {
			maxLevel = level;
			sum = currSum;
		} 
		
		maxLevelSum(root.left, currSum, level+1);
		maxLevelSum(root.right, currSum, level+1);
		
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
