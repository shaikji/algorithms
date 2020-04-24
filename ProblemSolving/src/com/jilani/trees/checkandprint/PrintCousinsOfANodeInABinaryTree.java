package com.jilani.trees.checkandprint;

public class PrintCousinsOfANodeInABinaryTree {

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
		
		Node node = root.left.left.left.left;
		
		printCousins(root, node);

	}
	
	static void printCousins( Node root, Node node ) {
		
		// 1. Find the level of the given node
		
		int level = findLevel(root, node,0);
		
		// 2. Print Nodes at the given level
		// 2.a  Make sure they are not siblings
		
		printNodesAtLevel(root, node, level);
	}
	
	static void printNodesAtLevel ( Node root, Node node, int level) {
		
		if ( root == null)
			return;
		
		if ( level == 1 ) {
			if (root.left == node || root.right == node)
				return;
			System.out.println(root.left.data);
			System.out.println(root.right.data);
		} else if ( level > 1 ) {
			
			printNodesAtLevel(root.left, node, level-1);
			printNodesAtLevel(root.right, node, level-1);
		}
	}
	
	static int findLevel(Node root, Node node, int level) {
		
		if ( root == null)
			return 0;
		
		if ( root== node ) {
			return level;
		}
		
		int left = findLevel(root.left, node, level+1);
		if ( left != 0)
			return left;
		
		int right = findLevel(root.right, node, level+1);
		if ( right != 0)
			return right;
		
		return 0;
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
