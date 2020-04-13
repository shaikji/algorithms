package com.jilani.queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ReversePath {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(10);
		// levelorder(root);
		inorder(root);
		System.out.println();
		reverse(root, 10, new HashMap<Integer, Integer>(), 0, new INT());
		System.out.println();
		inorder(root);
		System.out.println();
	}

	static class INT {
		int pos;
	}

	static Node reverse(Node root, int elem, Map<Integer, Integer> map, int level, INT nextpos) {
		if (root == null)
			return root;

		map.put(level, root.data);

		if (root.data == elem) {
			root.data = map.get(nextpos.pos);
			nextpos.pos++;
			return root;
		}

		Node left = null;
		Node right = null;

		left = reverse(root.left, elem, map, level + 1, nextpos);
		if (left == null)
			right = reverse(root.right, elem, map, level + 1, nextpos);

		if ( left != null || right != null) {
			root.data = map.get(nextpos.pos);
			nextpos.pos++;
		}
		
		
		
		return left != null? left : right; 
	}

	static boolean reverseV1(Node root, int elem, Queue<Integer> queue) {

		if (root == null)
			return false;
		queue.add(root.data);

		if (root.data == elem) {
			root.data = queue.poll();
			return true;
		}

		boolean left = reverseV1(root.left, elem, queue);

		if (left) {
			root.data = queue.poll();
			return left;
		}

		boolean right = reverseV1(root.right, elem, queue);

		if (right) {
			root.data = queue.poll();
			return right;
		}
		queue.poll();
		return false;

	}

	static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	static void levelorder(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList();
		queue.add(root);

		Node node;
		while (!queue.isEmpty()) {
			node = queue.poll();
			System.out.println(node.data);

			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);

		}
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
