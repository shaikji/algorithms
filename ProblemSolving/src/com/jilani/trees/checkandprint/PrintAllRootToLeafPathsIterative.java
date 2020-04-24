package com.jilani.trees.checkandprint;

import java.util.HashMap;
import java.util.Stack;

public class PrintAllRootToLeafPathsIterative {

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

		root.left.left.left.left = new Node(16);
		root.left.left.left.right = new Node(17);
		root.left.left.right.left = new Node(18);
		root.left.left.right.right = new Node(19);
		root.left.right.left.left = new Node(20);
		root.left.right.left.right = new Node(21);
		root.left.right.right.left = new Node(22);
		root.left.right.right.right = new Node(23);
		root.right.left.left.left = new Node(24);
		root.right.left.left.right = new Node(25);
		root.right.left.right.left = new Node(26);
		root.right.left.right.right = new Node(27);
		root.right.right.left.left = new Node(28);
		root.right.right.left.right = new Node(29);
		root.right.right.right.left = new Node(30);
		root.right.right.right.right = new Node(31);

		printPaths(root);
		
		System.out.println("------------");
		printPathsV2(root);
	}

	static void printPaths(Node root) {

		// Iterative pre-order

		if (root == null)
			return;
		Node node = root;
		Stack<Node> stack = new Stack();
		HashMap<Node, Node> parentMap = new HashMap();
		parentMap.put(root, null);

		while (true) {

			while (node != null) {
				if (node.left == null && node.right == null) {
					print(node, parentMap);
					//System.out.println();
				}
				stack.push(node);
				parentMap.put(node.left, node);
				node = node.left;
			}
			if (stack.isEmpty())
				break;

			node = stack.pop();
			if (null != node.right)
				parentMap.put(node.right, node);
			node = node.right;
		}

	}

	static void printPathsV2(Node root) {

		// Iterative pre-order

		if (root == null)
			return;
		Node node = root;
		Stack<Node> stack = new Stack();
		HashMap<Node, Node> parentMap = new HashMap();
		parentMap.put(root, null);
		stack.push(root);

		while (!stack.isEmpty()) {
			node = stack.pop();

			if (node.left == null && node.right == null) {
				print(node, parentMap);
			}

			if (node.right != null) {
				stack.push(node.right);
				parentMap.put(node.right, node);
			}

			if (node.left != null) {
				stack.push(node.left);
				parentMap.put(node.left, node);
			}
			
			
			
		}
	}

	static void print(Node node, HashMap<Node, Node> parentMap) {

		Stack<Integer> stack = new Stack();

		while (node != null) {
			stack.push(node.data);
			node = parentMap.get(node);
		}

		while (stack.size() > 1) {
			System.out.print(stack.pop() + " -> ");
		}
		System.out.println(stack.pop());
		//System.out.println();
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
