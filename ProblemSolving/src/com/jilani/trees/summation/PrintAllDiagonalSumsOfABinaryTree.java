package com.jilani.trees.summation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PrintAllDiagonalSumsOfABinaryTree {

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

		/*
		 * root.left.left.left.left = new Node(16); root.left.left.left.right = new
		 * Node(17); root.left.left.right.left = new Node(18);
		 * root.left.left.right.right = new Node(19); root.left.right.left.left = new
		 * Node(20); root.left.right.left.right = new Node(21);
		 * root.left.right.right.left = new Node(22); root.left.right.right.right = new
		 * Node(23); root.right.left.left.left = new Node(24);
		 * root.right.left.left.right = new Node(25); root.right.left.right.left = new
		 * Node(26); root.right.left.right.right = new Node(27);
		 * root.right.right.left.left = new Node(28); root.right.right.left.right = new
		 * Node(29); root.right.right.right.left = new Node(30);
		 * root.right.right.right.right = new Node(31);
		 */
		printDiagonalSum(root);
		
		printDiagonalSumIterative(root);
		System.out.println();
	}
	
	static void printDiagonalSum( Node root ) {
		
		if (null == root)
			return;
		
		HashMap<Integer, Integer> map = new HashMap();
		
		diagonal(root, map, 0);
		
		for (Integer key: map.keySet()) {
			System.out.println(key + " = " + map.get(key));
		}
	}
	
	static void diagonal ( Node root, HashMap<Integer, Integer> map, int d) {
		
		if ( root == null)
			return;
		
		map.put(d, map.getOrDefault(d, 0)+root.data);

		diagonal(root.left, map, d+1);
		diagonal (root.right, map, d);
	}
	
	static int printDiagonalSumIterative(Node root) {
		if (root == null)
			return 0;
		Queue<Node> q = new LinkedList();
		q.add(root);
		q.add(null);
		Node node;
		int sum = 0;
		while ( !q.isEmpty()) {
			node = q.poll();
			if ( node == null) {
				System.out.println(" sum = " + sum);
				sum = 0;
				if (q.isEmpty())
					break;
				q.add(null);
			} else {

				sum += node.data;
				
				while ( node.right != null) {
					sum += node.right.data;
					if (node.left != null)
						q.add(node.left);
					node = node.right;
				}	
			}
			
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
