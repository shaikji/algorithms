package com.jilani.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AlternateReverseOfPerfectBinaryTree {

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

		preorder(root);
		System.out.println();

		reverseAlternateLevels(root);
		System.out.println();

		preorder(root);
		System.out.println();

	}

	static void preorder(Node node) {
		if (node != null) {
			System.out.print(" " + node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	// Modified pre order

	static void reverseAlternateLevels(Node node) {

		if (node == null)
			return;

		modpreorder(node.left, node.right, 0);
	}

	static void modpreorder(Node node1, Node node2, int level) {

		if (node1 == null || node2 == null)
			return;

		if (level % 2 == 0) {
			int key = node1.data;
			node1.data = node2.data;
			node2.data = key;
		}

		modpreorder(node1.left, node2.right, level + 1);
		modpreorder(node1.right, node2.left, level + 1);
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
