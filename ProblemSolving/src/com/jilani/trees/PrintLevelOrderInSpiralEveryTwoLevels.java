package com.jilani.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintLevelOrderInSpiralEveryTwoLevels {

	public static void main(String[] args) {

		root = new Node(1); // 1
		root.left = new Node(2); // / \
		root.right = new Node(3); // 2 3
		root.left.left = new Node(4); // / \ / \
		root.left.right = new Node(5); // 4 5 6 7
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		
		root.left.left.left.left = new Node(12);
		root.left.left.left.right = new Node(13);
		
		levelOrderRecursive(root);
		System.out.println();
		levelOrderUsingQueueAndSTack(root);
		System.out.println();
	}

	public static Node root;

	public static void levelOrderRecursive(Node root) {

		int height = height(root);
		boolean ltr = true;
		int counter = 0;
		for (int level = 1; level <= height; level++) {
			printNodesAtLevel(root, level, ltr);
			System.out.println();
			counter++;
			if (counter == 2) {
				counter = 0;
				ltr = !ltr;
			}
		}
	}

	private static void printNodesAtLevel(Node root, int level, boolean ltr) {

		if (root == null)
			return;
		if (level == 1) {
			System.out.print(root.data + " ");
			return;
		}

		if (ltr) {
			printNodesAtLevel(root.left, level - 1, ltr);
			printNodesAtLevel(root.right, level - 1, ltr);
		} else {
			printNodesAtLevel(root.right, level - 1, ltr);
			printNodesAtLevel(root.left, level - 1, ltr);
		}
	}

	private static int height(Node node) {
		if (node == null)
			return 0;
		int lh = height(node.left);
		int rh = height(node.right);
		return 1 + Math.max(lh, rh);
	}

	public static void levelOrderUsingQueueAndSTack(Node root) {

		if (root == null)
			return;

		Queue<Node> q = new LinkedList();
		q.offer(root);
		q.offer(null);
		Stack s = new Stack<Integer>();
		
		Node n;
		boolean ltr = true;
		int counter =0;

		while (!q.isEmpty()) {
			n = q.poll();

			if (n == null) {
				if (!q.isEmpty())
					q.offer(null);

				if ( !ltr )
					while (!s.isEmpty()) {
						System.out.print(s.pop()+" ");
					}
				
				counter++;
				if ( counter == 2) {
					ltr = !ltr;
					counter =0;
				}
				System.out.println();
			} else {
				if ( ltr)
					System.out.print(n.data + " ");
				else {
					s.push(n.data);
				}
				if (n.left != null)
					q.offer(n.left);
				if (n.right != null)
					q.offer(n.right);
			}

		}
	}



	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

}
