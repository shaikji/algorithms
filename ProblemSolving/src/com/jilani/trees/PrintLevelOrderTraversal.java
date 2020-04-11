package com.jilani.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOrderTraversal {
	
	public static void main(String[] args) {
		
		root = new Node(1); 					//   1
		root.left = new Node(2); 	   		   // /    \
		root.right = new Node(3);             // 2      3
		root.left.left = new Node(4);        // / \    / \
		root.left.right = new Node(5);      // 4   5  6   7
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		levelOrderRecursive(root);
		levelOrderTraversalUsingOneQueue(root);
		levelOrderTraversalUsingTwoQueues(root);
	}
	
	public static Node root;
	public static void levelOrderRecursive(Node root) {
		
		int height = height(root);
		
		for ( int level=1; level <= height; level++) {
			printNodesAtLevel(root, level);
			System.out.println();
		}
	}
	
	private static void printNodesAtLevel(Node root, int level) {
		
		if ( root == null)
			return;
		if ( level == 1 ) {
			System.out.print(root.data+ " ");
			return;
		} 
		
		printNodesAtLevel(root.left, level-1);
		printNodesAtLevel(root.right, level-1);
	}
	private static int height(Node node) {
		if ( node == null)
			return 0;
		int lh = height(node.left);
		int rh = height(node.right);
		return 1 + Math.max(lh, rh);
	}
	
	public  static void levelOrderTraversalUsingOneQueue(Node root) {
		
		if ( root == null)
			return;
		
		Queue<Node> q = new LinkedList();
		q.offer(root);
		q.offer(null);
		
		Node n;
		
		while ( !q.isEmpty()) {
			n = q.poll();
			
			if ( n == null) {
				if ( !q.isEmpty())
					q.offer(null);
				System.out.println();
			} else {
				System.out.print(n.data +" ");
				if ( n.left != null)
					q.offer(n.left);
				if ( n.right != null )
					q.offer(n.right);
			}			
			
		}
	}
	
	public  static void levelOrderTraversalUsingTwoQueues(Node root) {
		
		if ( root == null)
			return;
		
		Queue<Node> currQ = new LinkedList();
		Queue<Node> nextQ = new LinkedList();

		currQ.offer(root);
		
		Node n;
		
		while (!currQ.isEmpty()) {
			n = currQ.poll();
			System.out.print(n.data + " ");
			
			if ( n.left != null)
				nextQ.add(n.left);
			if ( n.right != null)
				nextQ.add(n.right);
			
			if ( currQ.isEmpty()) {
				System.out.println();
				Queue<Node> temp = currQ;
				currQ= nextQ;
				nextQ = temp;
			}
		}
		
	}
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}

}
