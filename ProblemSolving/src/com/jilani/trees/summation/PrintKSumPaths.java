package com.jilani.trees.summation;

public class PrintKSumPaths {

	// Note: Path can start from any node, path can end from any node
	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(-1);

		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		
		root.left.right.left = new Node(1);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);
		root.right.right.right = new Node(6);
		
		
		int[] path = new int[100];
		printPathsWithSumK(root,path, 0, 5);
	}
	
	// Using post order
	static void printPathsWithSumK( Node root, int[] path, int pathlen, int K) {
		
		if ( root == null)
			return;
		
		path[pathlen++] = root.data;
		printPathsWithSumK(root.left, path,  pathlen, K);
		printPathsWithSumK(root.right, path,  pathlen, K);
		
		// Print path
		int sum = 0;
		for ( int i= pathlen-1; i>=0; i--) {
			sum += path[i];
			if (sum == K) {
				printPath(path, i, pathlen);
			}
		}
	}
	
	static void printPath(int[] path, int start, int end) {
		for ( int i=start; i < end; i++) {
			System.out.print(path[i] +" ");
		}
		System.out.println();
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
