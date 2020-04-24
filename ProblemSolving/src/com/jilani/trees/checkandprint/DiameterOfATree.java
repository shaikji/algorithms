package com.jilani.trees.checkandprint;

public class DiameterOfATree {

	public static void main(String[] args) {
		
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.left.left.right = new Node(8);
		root.left.left.right.left = new Node(9);
		
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(7);
		

		System.out.println(" Diameter = " + diameter(root));
		
		printDiameter(diameter_root);

	}
	
	static int flag =0;
	
	static void printDiameter(Node root) {
		
		if ( root == null)
			return;
		int[] lpath = new int[100];
		int pathLen = 0;
		flag = 0;
		printPath(root.left, lpath, pathLen, leftHeight);
		System.out.println(root.data );
		flag = 1;
		int[] rpath = new int[100];
		pathLen = 0;
		printPath(root.right, rpath, pathLen, rightHeight);
	}
	
	static void printPath ( Node node, int[] path, int pathLen, int height) {
		
		if ( node == null)
			return;
		
		path[pathLen++] = node.data;
		
		if ( node.left == null && node.right == null) {
			
			if (pathLen == height && (flag ==0 || flag == 1)) {
				printArray(path, pathLen, flag);
				flag = 2;
			}
			return;
		}
		
		printPath(node.left, path, pathLen, height);
		printPath(node.right, path, pathLen, height);

	}
	
	static void printArray(int[] path, int len, int flag ) {
		
		for ( int i=0; i < len; i++) {
			System.out.println(path[i]);
		}
		System.out.println(" printed ");
	}
	
	
	
	static Node diameter_root = null;
	static int leftHeight = 0;
	static int rightHeight = 0;
	static int ans = 0;
	
	static int diameter( Node root ) {
		
		if ( root == null)
			return 0;
		
		Height h = new Height();
		
		return findDiameter ( root, h);
		
	}
	
	static int findDiameter ( Node root, Height h) {
		
		if ( root == null) {
			return 0;
		}
		
		if ( root.left == null && root.right == null) {
			h.height = 1;
			return 1;
		}
		Height lh = new Height();
		int ld = findDiameter(root.left, lh);
		
		Height rh = new Height();
		int rd = findDiameter(root.right, rh);
		
		h.height = 1 + Math.max(lh.height, rh.height);
		
		if ( ans < 1 + lh.height + rh.height) {
			ans = 1 + lh.height + rh.height;
			leftHeight = lh.height;
			rightHeight = rh.height;
			diameter_root = root;
		}
		
		return Math.max(1 + lh.height + rh.height, Math.max(ld, rd));
	}
	static class Height{
		int height;
		Height() {
			this.height = 0;
		}
		Height(int h) {
			height = h;
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
