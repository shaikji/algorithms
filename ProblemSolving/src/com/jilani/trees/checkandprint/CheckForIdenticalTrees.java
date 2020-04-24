package com.jilani.trees.checkandprint;

import java.util.Stack;

public class CheckForIdenticalTrees {

	public static void main(String[] args) {

		root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);

		root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);

		System.out.println(" Is identical? " + isIdentical(root1, root2));
		
		System.out.println(" Is Identical? " + isIdenticalIterative(root1, root2));
	}

	static boolean isIdentical(Node root1, Node root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		return root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);

	}
	
	static boolean isIdenticalIterative(Node root1, Node root2) {
		
		if ( root1 == null && root2 == null)
			return true;
		
		Node node1 = root1;
		Stack<Node> stack1 = new Stack();
		
		Node node2 = root2;
		Stack<Node> stack2 = new Stack();
		
		
		
		while ( true ) {
			while ( node1 != null) {
				stack1.push(node1);
				node1 = node1.left;
			}	
			
			while ( node2 != null) {
				stack2.push(node2);
				node2 = node2.left;
			}
			if ( stack1.isEmpty()  && stack2.isEmpty() )
				break;
			
			if ( stack1.isEmpty() || stack2.isEmpty())
				return false;
			
			
			node1 = stack1.pop();
			node2 = stack2.pop();
			
			if ( node1.data != node2.data)
				return false;
			
			node1 = node1.right;
			node2 = node2.right;
		}
		
		return true;
	}

	static Node root1;
	static Node root2;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
}
