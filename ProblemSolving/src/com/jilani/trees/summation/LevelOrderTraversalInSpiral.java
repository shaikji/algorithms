package com.jilani.trees.summation;

import java.util.Stack;

public class LevelOrderTraversalInSpiral {

	public static void main(String[] args) {

		root = new Node(-1);
		root.left = new Node(-3);
		root.right = new Node(4);
		root.left.left = new Node(5);
		root.left.right = new Node(1);
		root.right.left = new Node(-2);
		root.right.right = new Node(-1);
		root.left.left.left = new Node(-3);
		root.right.right.right = new Node(2);
		
		
		printSpiral(root);
		 
		
	}
	
	static void printSpiral(Node root) {
		
		if ( root == null)
			return;
		
		int[] spiral = new int[100];
		int index = 0;
		
		Node node = root;
		Stack<Node> stack1  = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		boolean ltr = false;
		
		stack1.push(node);
		
		while ( !stack1.isEmpty()) {
			
			node = stack1.pop();
			
			System.out.print(node.data + " " );
			spiral[index++] = node.data;
		
			if (ltr) {
				if ( node.left != null)
					stack2.push(node.left);
				if ( node.right != null)
					stack2.push(node.right);
			} else {
				if ( node.right != null)
					stack2.push(node.right);
				if ( node.left != null)
					stack2.push(node.left);
			}
			
			if (stack1.isEmpty()) {
				// level is over
				ltr = !ltr;
				Stack<Node> tmp = stack1;
				stack1 = stack2;
				stack2 = tmp;
				System.out.println();
			}
			
		}
		
		int maxsum = maxSubarraySum(spiral, index);
		System.out.println(" Max Spriral Sum = " + maxsum);
	}
	
	static int maxSubarraySum(int[] spiral, int n) {
		
		// Find max sub array sum and return 
		// Use Kadane's algorithm
		
		int max_so_far = 0;
		int max_ending_here = 0;
		
		for ( int i=0; i < n; i++) {
			max_ending_here += spiral[i];
			
			if ( max_ending_here < 0 )
				max_ending_here = 0;
			
			if ( max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		
		return max_so_far;
	}
	
	
	
	

	private static Node root;
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
		}
	}

}
