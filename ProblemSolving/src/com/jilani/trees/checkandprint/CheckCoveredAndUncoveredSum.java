package com.jilani.trees.checkandprint;

public class CheckCoveredAndUncoveredSum {

	public static void main(String[] args) {

		root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(40);
		root.left.left = new Node(30);
		root.left.right = new Node(100);
		root.left.right.left = new Node(25);
		root.left.right.right = new Node(25);
		root.right.left = new Node(50);

		System.out.println(" SumTree =  " + isSumEqual(root));
	}

	static boolean isSumEqual(Node root) {
		
		if ( root == null)
			return true;
		
		int leftBoundarySum = leftSum(root.left);
		int rightBoundarySum = rightSum(root.right);
		
		int boundarySum = root.data + leftBoundarySum + rightBoundarySum;
		
		System.out.println(" Left Boundary Sum = " + leftBoundarySum);
		System.out.println(" Right Boundary Sum = " + rightBoundarySum);
		System.out.println(" root data = " + root.data);
		int treeSum = getSum(root);
		System.out.println(" Tree Sum = " + treeSum);
		System.out.println();
		
		System.out.println(" Covered  Sum = " + (treeSum - boundarySum) );
		System.out.println(" UnCovered  Sum = " + boundarySum);

		System.out.println(" ");
		return ((treeSum - boundarySum)  == boundarySum);
	}
	
	static int leftSum(Node node) {
		if ( node == null)
			return 0;
		
		int sum = node.data;
		
		if ( node.left != null ) {
			sum += leftSum(node.left);
		} else if ( node.right != null) {
			sum += leftSum(node.right);
		} 
		
		return sum;
	}
	
	static int rightSum(Node node) {
		if ( node == null)
			return 0;
		
		int sum = node.data;
		
		if ( node.right != null ) {
			sum += rightSum(node.right);
		} else if ( node.left != null) {
			sum += rightSum(node.left);
		} else {
			return node.data;
		}
		
		return sum;
	}
	
	static int getSum(Node root) {
		
		if ( root == null)
			return 0;
		
		int lsum = getSum(root.left);
		int rsum = getSum(root.right);
		
		return root.data + lsum + rsum;
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
