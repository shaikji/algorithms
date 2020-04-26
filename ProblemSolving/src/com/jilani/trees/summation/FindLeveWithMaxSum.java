package com.jilani.trees.summation;

import java.util.LinkedList;
import java.util.Queue;

public class FindLeveWithMaxSum {

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);


		int maxsum = findSum(root);
		
		System.out.println(" Level Max Sum = " + maxsum);
	}

	
	static int findSum(Node root) {

		int maxSum = Integer.MIN_VALUE;

		if (root == null)
			return 0;
		
		Queue<Node> q = new LinkedList();
		q.add(root);
		q.add(null);
		Node node;
		int sum = 0;
		while ( !q.isEmpty()) {
			node = q.poll();
			if ( node == null) {
				if ( maxSum < sum)
					maxSum = sum;
				sum = 0;
				if (!q.isEmpty())
					q.add(null);
			} else {

				sum += node.data;

				if ( node.left != null)
					q.add(node.left);
				if ( node.right != null)
					q.add(node.right);
			}
			
		}
		
		return maxSum;
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
