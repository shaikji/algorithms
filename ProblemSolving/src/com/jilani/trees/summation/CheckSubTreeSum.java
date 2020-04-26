package com.jilani.trees.summation;

import com.jilani.trees.summation.FindMaxSumSubTree.Result;

public class CheckSubTreeSum {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(6);

		root.left.left = new Node(5);
		root.left.right = new Node(9);
		root.right.left = new Node(8);
		
		int sum = 17;
		
		boolean exists = sumExists(root, sum, new Result());
		System.out.println(" Sum = " + sum + " exists = " + exists);
		System.out.println();
		
		sum = 11;
		exists = sumExists(root, sum, new Result());
		System.out.println(" Sum = " + sum + " exists = " + exists);
		
	}
	
	
	static boolean sumExists( Node root, int K, Result res) {
		
		if ( root == null) {
			res.sum = 0;
			return false;
		}
		Result ls = new Result();
		boolean left  = sumExists(root.left, K, ls);
		
		if (left)
			return left;
		
		Result rs = new Result();
		boolean right = sumExists(root.right, K,  rs);
		if (right)
			return right;
		
		int sum = root.data + ls.sum + rs.sum;
		res.sum = sum;
		
		return sum == K;
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
