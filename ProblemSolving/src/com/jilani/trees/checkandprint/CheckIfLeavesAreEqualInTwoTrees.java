package com.jilani.trees.checkandprint;

import java.util.Stack;

public class CheckIfLeavesAreEqualInTwoTrees {

	public static void main(String[] args) {

		root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.right.left = new Node(6);
		root1.right.right = new Node(7);
		
		root2 = new Node(0);
		root2.left = new Node(5);
		root2.right = new Node(8);
		root2.left.right = new Node(4);
		root2.right.left = new Node(6);
		root2.right.right = new Node(7);
		

		System.out.println(" Leaves Equal in both trees? =  " + areLeavesEqual(root1, root2));
	}
	
	static boolean areLeavesEqual(Node root1, Node root2) {
		
		if ( root1 == null && root2 == null)
			return true;
		
		if ( root1 == null || root2 == null)
			return false;
		
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		
		Node temp1 = root1;
		Node temp2 = root2;
		
		while ( !stack1.isEmpty() || !stack2.isEmpty() ) {
			
			// If one is empty & other is not empty return false
			if ( stack1.isEmpty() || stack2.isEmpty())
				return false;
			
			
			temp1 = stack1.pop();
			
			while ( temp1 != null && !isLeaf(temp1)) {
				
				if (temp1.right != null)
					stack1.push(temp1.right);
				if ( temp1.left != null)
					stack1.push(temp1.left);
				temp1 = stack1.pop();
			}
			
			temp2 = stack2.pop();
			
			while ( temp2 != null && !isLeaf(temp2)) {
				
				if (temp2.right != null)
					stack2.push(temp2.right);
				if ( temp2.left != null)
					stack2.push(temp2.left);
				temp2 = stack2.pop();
			}
			
			if ( (temp1 == null && temp2 != null) || (temp1 != null && temp2 == null) )
				return false;
			
			if ( temp1 != null && temp2 != null ) {
				if ( temp1.data != temp2.data)
					return false;
			}
			
		}
		
		return true;
		
	}

	
	static boolean isLeaf(Node node) {
		if ( node.left == null && node.right == null)
			return true;
		return false;
	}

	static Node root1;
	static Node root2;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
}
