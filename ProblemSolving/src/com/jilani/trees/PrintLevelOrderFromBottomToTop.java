package com.jilani.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintLevelOrderFromBottomToTop {

	public static void main(String[] args) {

		root = new Node(1); 			// 1
		root.left = new Node(2); 	   // / \
		root.right = new Node(3);     // 2 3
		root.left.left = new Node(4); // / \ / \
		root.left.right = new Node(5); // 4 5 6 7
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		levelOrderUsingQueueAndSTack(root);
	}

	public static Node root;

	public static void levelOrderUsingQueueAndSTack(Node root) {

		if (root == null)
			return;

		Queue<Node> q = new LinkedList();
		q.offer(root);
		q.offer(null);
		Stack<Integer> s = new Stack<Integer>();

		Node n;

		while (!q.isEmpty()) {
			n = q.poll();

			if (n == null) {
				if (!q.isEmpty()) {
					q.offer(null);
					s.push(-1);
				}
			} else {
				s.push(n.data);

				if (n.right != null)
					q.offer(n.right);

				if (n.left != null)
					q.offer(n.left);
			}

		}

		int num;
		
		while (!s.isEmpty()) {
			num = s.pop();
			if (num == -1)
				System.out.println();
			else
				System.out.print(num + " ");
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
