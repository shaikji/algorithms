package com.jilani.trees.summation;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveNodesWithSumLessThanK {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);

		int K = 20;
		
		removeNodes(root, K);

	}
	
	static void removeNodes( Node root, int K) {
		
		if ( root == null)
			return;
		int currSum = 0;
		
		root = remove(root, K, 0);
		printLevelOrder(root);
		
	}

	
	static void printLevelOrder(Node root) {
		
		if ( root == null)
			return;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		Node node;
		
		while ( !q.isEmpty() ) {
			node = q.poll();
			if ( node == null) {
				if ( !q.isEmpty())
					q.add(null);
				System.out.println();
			} else {
				System.out.print(node.data + " ");
				if ( node.left != null)
					q.add(node.left);
				if ( node.right != null)
					q.add(node.right);
			}
		}
	}
	static Node remove (Node node, int K, int sum) {
		
		if (node == null)
			return null;
		
		sum = sum + node.data;
		if (node.left == null && node.right == null) {
			
			if ( sum < K) {
				return null;
			} else {
				return node;
			}
		}
		node.left = remove(node.left, K, sum);
		node.right = remove(node.right, K, sum);
		
		if ( node.left == null && node.right == null) {
			return null;
		}
		
		return node;
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
