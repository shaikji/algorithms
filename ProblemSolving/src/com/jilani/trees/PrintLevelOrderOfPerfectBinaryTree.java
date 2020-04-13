package com.jilani.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOrderOfPerfectBinaryTree {

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

		printLevelOrder(root);

	}

	static void printLevelOrder(Node node) {

		if (node == null)
			return;
		System.out.print(node.data + " ");
		if (node.left != null)
			System.out.print(node.left.data + " ");
		System.out.print(node.right.data + " ");

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root.left);
		queue.add(root.right);
		Node first;
		Node second;

		while (!queue.isEmpty()) {
			first = queue.poll();
			second = queue.poll();

			if (first.left == null)
				return;

			queue.add(first.left);
			queue.add(second.right);
			queue.add(first.right);
			queue.add(second.left);
			
			System.out.print(first.left.data +" ");
			System.out.print(second.right.data +" ");
			System.out.print(first.right.data +" ");
			System.out.print(second.left.data +" ");

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
