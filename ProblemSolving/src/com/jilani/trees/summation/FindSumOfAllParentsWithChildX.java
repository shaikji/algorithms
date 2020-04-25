package com.jilani.trees.summation;

public class FindSumOfAllParentsWithChildX {

	public static void main(String[] args) {

		root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);

		root.left.left = new Node(7);
		root.left.right = new Node(2);
		root.right.left = new Node(2);
		root.right.right = new Node(3);

		int x = 2;
		
		System.out.println(" Sum = " + sum(root, x));
	}
	
	
	static int sum( Node root, int x) {
		
		if ( root == null)
			return 0;
		
		int sum = 0;
		
		if ( root.left != null && root.left.data == x || root.right != null && root.right.data == x )
			sum = root.data;
		return sum + sum(root.left,x) + sum(root.right,x);
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
