package com.jilani.trees.summation;

import java.util.HashMap;

// Note: The below code works also for duplicates because, in the map we are using Node as the key and not the value.

public class MaxSumNonAdjancentNodes {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(1);
		root.right.left = new Node(4);
		root.right.right = new Node(5);

		System.out.println(" Sum = " + maxSum(root));
		System.out.println(" Sum = " + maxSumV2(root));
	}
	
	static class Pair{
		
		int sum_incl;
		int sum_excl;
		
		Pair(int incl, int excl){
			this.sum_incl = incl;
			this.sum_excl = excl;
		}
		Pair(){
			this.sum_excl = 0;
			this.sum_incl= 0;
		}
	}
	
	static int maxSumV2(Node root) {
		
		if ( root == null)
			return 0;
		
		Pair pair = findMaxSumPair(root);
		return Math.max(pair.sum_incl,pair.sum_incl);
	}
	
	static Pair findMaxSumPair(Node root) {
		
		if (root == null) {
			return new Pair();
		} 
		
		if ( root.left == null && root.right == null) {
			return new Pair(root.data, 0);
		}
		
		Pair left = findMaxSumPair(root.left);
		Pair right = findMaxSumPair(root.right);
		
		
		// If you include the current node, then you cannot include the immediate children
		int incl = root.data + left.sum_excl + right.sum_excl;
		
		// If you don't include the current node, then you may or may not include the next node
		// Your decision will be depending on the max sum
		
		// 
		int excl = Math.max(left.sum_incl, left.sum_excl) + Math.max(right.sum_incl, right.sum_excl);
				
		return new Pair(incl, excl);
	}
	

	static int maxSum (Node root) {
	
		if ( root == null)
			return 0;
		
		HashMap<Node, Integer> map = new HashMap();
		
		return findMaxSum(root, map);
	}
	
	static int findMaxSum(Node root, HashMap<Node,Integer> map) {
		
		if ( root == null)
			return 0;
		
		if ( map.containsKey(root)) {
			return map.get(root);
		}
		
		int incl = root.data + getGrandChildrenSum(root, map);
		int excl = findMaxSum(root.left, map) + findMaxSum(root.right, map);
		
		return Math.max(incl, excl);
		
	}
	
	static int getGrandChildrenSum(Node root,  HashMap<Node,Integer> map) {
		
		if ( root == null)
			return 0;
		
		int sum = 0;
		
		if ( root.left != null) {
			sum += findMaxSum(root.left.left, map);
			sum += findMaxSum(root.left.right, map);
		}
		
		if (root.right != null) {
			sum += findMaxSum(root.right.left, map);
			sum += findMaxSum(root.right.right, map);
		}
		
		return sum;
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
