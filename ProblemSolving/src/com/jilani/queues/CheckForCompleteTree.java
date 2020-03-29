package com.jilani.queues;

import java.util.LinkedList;
import java.util.Queue;

public class CheckForCompleteTree {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		System.out.println(" IsComplete = " + isTreeComplete(root));
	}

	static boolean isTreeComplete(Node root) {

		if (root == null)
			return true;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node node;
		boolean flag = false;

		while (!queue.isEmpty()) {

			node = queue.poll();
			if (node.left == null && node.right != null)
				return false;

			if (flag) {
				if (node.left != null || node.right != null)
					return false;
			} else {

				if (node.left == null || node.right == null) {
					flag = true;
				}
			}
			
			if ( node.left != null)
				queue.add(node.left);
			if ( node.right != null)
				queue.add(node.right);

		}

		return true;

	}

	static Node root;

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

}
