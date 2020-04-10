package com.jilani.trees;

public class FindNthNodeInInorder {

	public static void main(String[] args) {

		root = new Node(1); 					//   1
		root.left = new Node(2); 	   		   // /    \
		root.right = new Node(3);             // 2      3
		root.left.left = new Node(4);        // / \    / \
		root.left.right = new Node(5);      // 4   5  6   7
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		inorder(root);

		int i = 7;

		findNthNodeInInorder(root, i);
		// System.out.println( i + "th Node in Inorder = " + ((nthNode == null) ? -1 :
		// nthNode.data));

		/*
		 * for (int i = 2; i < 9; i++) { inSucc = findInorderSuccessor(root, i);
		 * System.out.println("In Order Successor of " + i + " = " + ((inSucc == null) ?
		 * -1 : inSucc.data)); System.out.println(); }
		 */

	}

	static Node nthNode = null;
	static Node next;
	static int count = 0;

	static void findNthNodeInInorder(Node node, int k) {
		if (node == null)
			return;

		if (count <= k) {
			findNthNodeInInorder(node.left, k);
			count++;
			if (k == count)
				System.out.println(k + "th node in inorder = " + node.data);
			
			findNthNodeInInorder(node.right, k);
		}

	}

	static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root.data + " ");
			inorder(root.right);
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
