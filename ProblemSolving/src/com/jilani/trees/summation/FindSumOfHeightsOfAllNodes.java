package com.jilani.trees.summation;

public class FindSumOfHeightsOfAllNodes {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		
		
		System.out.println(" sum of heights = " + sum (root));
	}
	
	
	static int sum(Node root) {
		
		if (root == null)
			return 0;
		
		Result res = new Result();
		sumOfHeights(root, res);
		return res.sum;
	}
	
	static class Result{
		int sum;
		Result(int s){
			this.sum = s;
		}
		Result(){
			this.sum = 0;
		}
	}
	
	
	static int sumOfHeights( Node root, Result res) {
		
		if ( root == null)
			return 0;
		
		int lh = sumOfHeights(root.left,res);
		int rh = sumOfHeights(root.right,res);
		
		int h = 1 + Math.max(lh, rh);
		
		res.sum += h;
		
		return h;
		
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
