package com.jilani.trees.checkandprint;

public class CheckForLeafLevels {

	public static void main(String[] args) {

		root = new Node(12);
		root.left = new Node(5);
		root.left.left = new Node(3);
		root.left.right = new Node(9);
		root.left.left.left = new Node(1);
		root.left.right.right = new Node(2);


		System.out.println(" Are leafs at the same level  =  " + checkLeafLevels(root, 0));
	}
	
	
	static int leafLevel = -1;

	static boolean checkLeafLevels(Node root, int level) {
		
		if ( root == null)
			return true;
		
		if (isLeaf(root)) {
			// If level is not set set the level
			if (leafLevel == -1) {
				leafLevel = level;
			} else {
				// level is already set, now check if the leafs are at same level
				if ( leafLevel != level)
					return false;
			}
			return true;
		} else {
			
			boolean left = checkLeafLevels(root.left, level + 1);
			if ( left )
				return checkLeafLevels(root.right, level + 1);
			return left;
		}
	}
	
	static boolean isLeaf(Node node) {
		return node.left == null && node.right == null;
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
