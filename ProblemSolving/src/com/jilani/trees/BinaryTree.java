package com.jilani.trees;

import java.util.Stack;

public class BinaryTree {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(8);
		root.right.left.right = new Node(9);
		
		inorder(root);
		System.out.println();
		inorderIt(root);

	}
	
	static void inorder(Node node) {
		if ( node != null) {
			inorder(node.left);
			System.out.print(" " + node.data);
			inorder(node.right);
		}
	}
	
	static void inorderIt(Node root) {
		
		if ( root == null)
			return;
		
		Node node= root;
		Stack<Node> stack = new Stack<Node>();
		
		while (true) {
						
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			
			if ( stack.isEmpty())
				break;
			
			node = stack.pop();
			System.out.print(" " + node.data);

			node = node.right;
			
		}
		
		System.out.println();
	}

	static Node root;
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
		}
	}

}
