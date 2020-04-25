package com.jilani.trees.summation;

public class FindMaxPathSumFromRootToLeaf {

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
		
		maxPathSum(root,0);
		
		System.out.println(" Sum = " + maxsum );
		
		printPath(root, target_leaf);
	}
	
	static boolean printPath ( Node root, Node target_leaf) {
		
		if ( root == null) {
			return false;
		}
		
		if ( root.left == null && root.right == null ) {
			if ( root == target_leaf) {
				System.out.println(root.data + " ");
				return true;
			}
		}
		
		if ( printPath(root.left, target_leaf)|| printPath(root.right, target_leaf)) {
			System.out.println(root.data +" ");
			return true;
		}
		
		return false;
		
	}
	
	static Node target_leaf = null;
	
	static void maxPathSum( Node root, int sum) {
		
		if ( root == null)
			return;
		
		sum += root.data;
		
		if ( root.left == null && root.right == null) {
			if ( maxsum < sum) {
				maxsum = sum;
				target_leaf = root;
			}
			return;
		}
		
		maxPathSum(root.left, sum);
		maxPathSum(root.right, sum);
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
