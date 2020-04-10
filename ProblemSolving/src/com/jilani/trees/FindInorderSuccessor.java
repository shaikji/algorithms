package com.jilani.trees;

public class FindInorderSuccessor {

	public static void main(String[] args) {

		root = new Node(1); // 1
		root.left = new Node(2); // / \
		root.right = new Node(3); // 2 3
		root.left.left = new Node(4); // / \ / \
		root.left.right = new Node(5); // 4 5 6 7
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		inorder(root);

		int i = 6;

		findInorderSuccessor(root, i);
		System.out.println("In Order Successor of " + i + " = " + ((successor == null) ? -1 : successor.data));

		/*
		 * for (int i = 2; i < 9; i++) { inSucc = findInorderSuccessor(root, i);
		 * System.out.println("In Order Successor of " + i + " = " + ((inSucc == null) ?
		 * -1 : inSucc.data)); System.out.println(); }
		 */

	}

	static Node successor = null;
	static Node next;

	static void findInorderSuccessor(Node node, int k) {
		if (node == null)
			return;

		if (successor != null) 
			return;
		
		findInorderSuccessor(node.right, k);

		if ( node.data == k) {
			successor = next;
			System.out.println(" successor of " + k + " = " + ((successor == null) ? -1: successor.data));
			return;
		} else {
			next = node;
		}
		
		findInorderSuccessor(node.left, k);
	}

	static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root.data + " " + getNext(root));
			inorder(root.right);
		}
	}

	static int getNext(Node root) {
		if (root == null || root.next == null)
			return -1;
		return root.next.data;
	}

	static Node root;

	static class Node {
		int data;
		Node next;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

}
