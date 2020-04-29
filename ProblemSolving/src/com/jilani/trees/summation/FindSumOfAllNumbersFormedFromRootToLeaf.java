package com.jilani.trees.summation;

public class FindSumOfAllNumbersFormedFromRootToLeaf {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		System.out.println("sum  = " + findSum(root, 0));
	}

	static int findSum(Node root, int sum) {

		if (root == null) {
			return 0;
		}

		sum = sum * 10 + root.data;
		if (root.left == null && root.right == null) {
			System.out.println("sum = " + sum);
			return sum;
		}

		return findSum(root.left, sum) + findSum(root.right, sum);
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
