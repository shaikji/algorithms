package com.jilani.trees.checkandprint;

public class PrintMiddleLevelOfPerfectBinaryTree {

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

		printMiddleLevel(root,0);
		System.out.println();
		
		printMiddleLevel2(root,root);
		System.out.println();

	}
	
	static int maxLevel = -1;
	
	static void printMiddleLevel(Node root, int level) {
	
		if ( root != null) {
			
			printMiddleLevel(root.left, level + 1);
			
			if (maxLevel == -1 )
				maxLevel = level;
			
			if ( level == maxLevel/2)
				System.out.println(root.data);
			
			printMiddleLevel(root.right, level + 1);
		}
	}
	
	static void printMiddleLevel2(Node slow, Node fast) {
		
		if ( slow == null || fast == null)
			return;
		
		if ( fast.left == null && fast.right == null) {
			System.out.println(slow.data);
			return;
		}
		
		
		printMiddleLevel2(slow.left, fast.left.left);
		printMiddleLevel2(slow.right, fast.left.left);
		
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
