package com.jilani.trees.summation;

import java.util.LinkedList;
import java.util.Queue;

public class FindSumOfMinLeafNodes {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		//root.right.left = new Node(6);
		//root.right.right = new Node(7);
		root.left.right.left = new Node(8);
		//root.right.left.right = new Node(9);
		
		mxdepth(root,0);
		System.out.println(" sum = " + sum );
	}
	static int min_level = Integer.MAX_VALUE;
	static int sum = 0;
	
	static int minLevelDepth(Node root) {
		
		if ( root == null)
			return 0;
		
		int level =0;
		
		Queue<Node> q = new LinkedList();
		q.add(root);
		q.add(null);
		boolean flag = false;
		Node node = null;
		int sum =0;
		
		while ( !q.isEmpty() ) {
			node = q.poll();
			
			
			if ( null == node ) {
				if ( !q.isEmpty())
					q.add(null);
				if ( flag )
					break;
			} else {
				
				if ( node.left == null && node.right == null) {

					if ( !flag ) {
						flag = true;
					}
					sum += node.data;
				} 
				
				if ( node.left != null)
					q.add(node.left);
				
				if (node.right != null)
					q.add(node.right);
			}
			
		}
		
		return sum;
	}
	
	static void mxdepth(Node root, int level) {
		
		if (root == null)
			return;
		
		if ( root.left == null && root.right == null) {
			if ( level < min_level) {
				sum = root.data;
				min_level = level;
			} else if ( level == min_level) {
				sum += root.data;
			}	
		}
		
		mxdepth(root.left, level+1);
		mxdepth(root.right, level + 1);
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
