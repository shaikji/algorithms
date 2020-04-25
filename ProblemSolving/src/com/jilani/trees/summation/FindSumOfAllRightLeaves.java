package com.jilani.trees.summation;

public class FindSumOfAllRightLeaves {

	public static void main(String[] args) {

		root = new Node(9);
		root.left = new Node(8);
		root.right = new Node(6);

		root.left.left = new Node(5);
		root.left.right = new Node(2);
		root.right.left = new Node(1);
		
		System.out.println(" Sum = " + sum(root));
	}
	
	
	static int sum( Node root) {
		
		if ( root == null)
			return 0;

		int sum = 0;
		if ( isLeaf(root.right))
			sum = root.right.data;

		return sum + sum(root.left) + sum(root.right);
	}
	
	static boolean isLeaf( Node node) {
		if ( node != null && node.left == null && node.right == null)
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
