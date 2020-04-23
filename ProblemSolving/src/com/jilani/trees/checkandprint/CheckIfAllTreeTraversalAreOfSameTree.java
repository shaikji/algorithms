package com.jilani.trees.checkandprint;

public class CheckIfAllTreeTraversalAreOfSameTree {

	public static void main(String[] args) {

		int[] in = { 4, 2, 5, 1, 3 };
		int[] pre = { 1, 2, 4, 5, 3 };
		int[] post = { 4, 5, 2, 3, 1 };

		index = 0;
		root = constructBT(pre, in);

		index = 0;
		boolean res = areTraversalsSame(root, post);
		System.out.println(" Are traversals same = " + res);
	}

	static Node constructBT(int[] pre, int[] in) {

		if (pre == null || in == null) {
			return null;
		}

		return constructBTUtil(pre, in, 0, pre.length - 1);
	}

	static Node constructBTUtil(int[] pre, int[] in, int start, int end) {

		if (index >= pre.length || start > end) {
			return null;
		}

		Node node = new Node(pre[index++]);

		if (start == end)
			return node;
		
		int idx = findIndex(in,node.data);
		node.left = constructBTUtil(pre, in, start, idx - 1);
		node.right = constructBTUtil(pre, in, idx + 1, end);

		return node;
	}

	static int findIndex(int[] in, int elem) {

		for (int i = 0; i < in.length; i++) {
			if (in[i] == elem)
				return i;
		}
		return -1;
	}

	static boolean areTraversalsSame(Node root, int[] post) {

		if (null == root)
			return true;

		boolean left = areTraversalsSame(root.left, post);
		if (!left)
			return false;
		
		boolean right = areTraversalsSame(root.right, post);
		if (!right)
			return false;
		
		if (root.data != post[index]) {
			return false;
		}
		index++;
		return true;
	}

	static int index;
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
