package com.jilani.trees.summation;

import java.util.HashSet;

public class CheckIfThereIsAPairWithSumXInRootToLeaf {

	public static void main(String[] args) {

		root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(3);
		root.left.right = new Node(4);
		
		root.left.right.left = new Node(6);
		root.left.right.right = new Node(8);


		
		System.out.println(" hasPair = " + hasPair(root));
	}
	
	
	static boolean hasPair( Node root) {
		
		if ( root == null)
			return false;
		
		HashSet<Integer> set = new HashSet();
		
		return hasPairSum(root.left, root.data, set) || hasPairSum(root.right, root.data, set);
	}
	
	
	static boolean hasPairSum(Node node, int root_data, HashSet<Integer> set) {
		
		if (node == null)
			return false;
		
		int rem = root_data - node.data;
		if (set.contains(rem))
			return true;
		set.add(node.data);
		
		boolean result = hasPairSum(node.left, root_data, set) ||
				hasPairSum(node.right, root_data, set);
		
		set.remove(node.data);
		
		return result;
		
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
