package com.jilani.trees.checkandprint;

public class CheckForMirror {

	public static void main(String[] args) {

		root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		// root1.left.left = new Node(4);

		root2 = new Node(1);
		root2.left = new Node(3);
		root2.right = new Node(2);
		// root2.right.right = new Node(4);

		System.out.println(" Is mirror image? " + isMirror(root1, root2));
	}

	static boolean isMirror(Node root1, Node root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		return root1.data == root2.data && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);

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
