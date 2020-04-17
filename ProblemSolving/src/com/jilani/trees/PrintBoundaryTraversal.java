package com.jilani.trees;

public class PrintBoundaryTraversal {

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
		// root.left.left.left.left.right = new Node(77);
		// root.left.left.left.left.right.left = new Node(88);
		// root.left.left.left.left.right.left.left = new Node(99);

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

		printBoundary(root);
		System.out.println();

	}

	static void printBoundary(Node node) {

		if (node == null)
			return;
		System.out.println(node.data);
		printBoundaryLeft(node.left);
		printLeaves(node);
		printBoundaryRight(node.right);
	}
	
	static void printBoundaryRight(Node node) {
		
		if ( node != null) {
			
			if ( node.right != null) {
				printBoundaryRight(node.right);
				System.out.println(node.data);
			}
			else if ( node.left != null) {
				printBoundaryRight(node.left);
				System.out.println(node.data);
			}
			
		}
	}

	static void printLeaves(Node node) {
		if (node != null) {

			printLeaves(node.left);
			if (node.left == null && node.right == null)
				System.out.println(node.data + " ");
			printLeaves(node.right);
		}
	}

	static void printBoundaryLeft(Node node) {

		if (node != null) {

			if (node.left != null) {
				System.out.println(node.data + " ");
				printBoundaryLeft(node.left);
			}

			else if (node.right != null) {
				System.out.println(node.data + " ");
				printBoundaryLeft(node.right);
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
