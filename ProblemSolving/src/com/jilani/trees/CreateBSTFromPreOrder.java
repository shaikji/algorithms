package com.jilani.trees;

public class CreateBSTFromPreOrder {

	public static void main(String[] args) {

		int[] pre = { 10, 5, 1, 7, 40, 50 };

		createBST(pre);
		inorder(root);
		preorder(root);
		postorder(root);
	}
	
	static class Index{
		int index;
		Index(int i){
			index = i;
		}
	}

	static void createBST(int[] pre) {
		if (pre == null || pre.length == 0)
			return;

		Index index = new Index(0);
		root = createBSTUtil(pre, 0, pre.length - 1, index);
	}

	static Node createBSTUtil(int[] pre, int start, int end, Index I) {
		
		
		int index = I.index;
		if (index >= pre.length || start > end)
			return null;

		Node node = new Node(pre[index]);
		I.index = I.index + 1;
		
		if ( start == end)
			return node;
		
		int idx = findNextGreater(pre, start, end);
		
		node.left = createBSTUtil(pre, start + 1, idx - 1, I);
		node.right = createBSTUtil(pre, idx, end, I);
		return node;

	}

	static int findNextGreater(int[] pre, int start, int end) {

		int elem = pre[start];
		for (int i = start + 1; i <= end; i++) {
			if (pre[i] > elem)
				return i;
		}
		return -1;
	}

	static void inorder(Node root) {

		System.out.println(" INORDER ");
		inorderRec(root);
		System.out.println();
		System.out.println();
	}

	static private void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(" " + root.data);
			inorderRec(root.right);
		}
	}

	static void preorder(Node root) {

		System.out.println(" PREORDER ");
		preorderRec(root);
		System.out.println();
		System.out.println();

	}

	static private void preorderRec(Node root) {
		if (root != null) {
			System.out.print(" " + root.data);
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}

	static void postorder(Node root) {

		System.out.println(" POSTORDER ");
		postorderRec(root);
		System.out.println();
		System.out.println();

	}

	static private void postorderRec(Node root) {
		if (root != null) {
			postorderRec(root.left);
			postorderRec(root.right);
			System.out.print(" " + root.data);
		}
	}

	static Node root;
	static int index = 0;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

}
