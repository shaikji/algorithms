package com.jilani.trees.summation;

public class FindMaxSumSubTree {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(-2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(-6);
		root.right.right = new Node(2);
		
		Result res = new Result();
		sum(root, res);
		System.out.println(" Sum = " + res.sum);
	}
	
	static class Result{
		int sum;
		Result(){
			sum = 0;
		}
		Result(int n){
			sum = n;
		}
	}
	
	static int sum( Node root, Result res) {
		
		if ( root == null)
			return 0;
		
		int lsum = sum(root.left, res);
		int rsum = sum(root.right, res);
		
		int sum = root.data + lsum+rsum;
		
		if (res.sum < sum) {
			res.sum = sum;
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
