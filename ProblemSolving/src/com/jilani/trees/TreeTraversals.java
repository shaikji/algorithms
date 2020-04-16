package com.jilani.trees;

import java.util.Stack;

public class TreeTraversals {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

// INorder
		System.out.println();
		inorder(root);
		System.out.println();
		inorderIterative(root);
		System.out.println();
		morrisInorder(root);
		System.out.println();
		
// Pre
		System.out.println();
		preorder(root);
		System.out.println();
		preorderIterative(root);
		System.out.println();
		morrisPreorder(root);
		System.out.println();
		
// Post
		System.out.println();
		postorder(root);
		System.out.println();
		postorderIterative(root);
		postorderIterativeUsingOneStack(root);
		System.out.println();
		
	}

	static void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(" " + node.data);
			inorder(node.right);
		}
	}

	static void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(" " + node.data);
		}
	}

	static void inorderIterative(Node node) {

		Stack<Node> stack = new Stack<Node>();
		while (true) {

			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			if (stack.isEmpty())
				break;

			node = stack.pop();
			System.out.print(" " + node.data);
			node = node.right;
		}
	}

	static void preorder(Node node) {
		if (node != null) {
			System.out.print(" " + node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	static void preorderIterative(Node node) {

		Stack<Node> stack = new Stack<Node>();
		while (true) {

			while (node != null) {
				System.out.print(" " + node.data);
				stack.push(node);
				node = node.left;
			}

			if (stack.isEmpty())
				break;

			node = stack.pop();
			node = node.right;
		}
	}

	static void postorderIterative(Node node) {

		Stack<Node> stack = new Stack<Node>();
		Stack<Integer> values = new Stack();
		while (true) {

			while (node != null) {
				values.add(node.data);
				stack.push(node);
				node = node.right;
			}

			if (stack.isEmpty())
				break;

			node = stack.pop();
			node = node.left;
		}

		while (!values.isEmpty()) {
			System.out.print(" " + values.pop());
		}
		System.out.println();
	}

	static void postorderIterativeUsingOneStack(Node root) {

		Node node = root;
		Stack<Node> stack = new Stack();

		while (true) {

			while (node != null) {

				if (node.right != null)
					stack.push(node.right);
				stack.push(node);
				node = node.left;
			}
			if (stack.isEmpty())
				break;

			node = stack.pop();
			
			
			// If node has right child
			if (!stack.isEmpty() && node.right != null && node.right.data == stack.peek().data) {
				Node right = stack.pop();
				stack.push(node);
				node = right;
			} else {
				System.out.print(" " + node.data);
				node = null;
			}

		}
	}
	
	static void morrisInorder(Node root) {
		
		Node node = root;
		
		while ( node != null) {
			
			if ( node.left == null) {
				System.out.print(" " + node.data);
				node = node.right;
			} else {
				Node predecessor = node.left;
				
				while (predecessor.right != null) {
					
					if (predecessor.right.data == node.data)
						break;
					predecessor = predecessor.right;
				}
				
				if (predecessor.right == null) {
					predecessor.right = node;
					node = node.left;
				} else {
					predecessor.right = null;
					System.out.print(" " + node.data);
					node = node.right;
				}
			}
		}
	}
	
	static void morrisPreorder(Node root) {
		
		Node node = root;
		
		while ( node != null) {
			
			if ( node.left == null) {
				System.out.print(" " + node.data);
				node = node.right;
			} else {
				Node predecessor = node.left;
				
				while (predecessor.right != null) {
					
					if (predecessor.right.data == node.data)
						break;
					predecessor = predecessor.right;
				}
				
				if (predecessor.right == null) {
					System.out.print(" " + node.data);
					predecessor.right = node;
					node = node.left;
				} else {
					predecessor.right = null;
					node = node.right;
				}
			}
		}
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
