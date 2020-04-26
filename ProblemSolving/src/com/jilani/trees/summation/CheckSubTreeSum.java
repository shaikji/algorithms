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
		
		Result res = new Result();
		
		boolean exists = sumExists(root, sum, res);
		System.out.println(" Sum = " + sum + " exists = " + exists+" count = " + count);
		System.out.println();
		
	}
	
	static int count =0;
	
	static boolean sumExists( Node root, int K, Result res) {
		
		if ( root == null) {
			res.sum = 0;
			return false;
		}
		Result ls = new Result();
		boolean left = sumExists(root.left, K, ls);
		
		Result rs = new Result();
		boolean right = sumExists(root.right, K,  rs);
		
		int sum = root.data + ls.sum + rs.sum;
		
		boolean result = (sum == K);
		
		res.sum = sum;
		if (result)
			count++;
				
		return result || left || right;
	}
	
	static class Result{
		int sum;
		int count;
		
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
