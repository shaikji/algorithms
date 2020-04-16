package com.jilani.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PrintAllDiagonalsOfABinaryTree {

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

		printDiagonals(root);
		
		System.out.println();
		diagonalsIterative(root);
		System.out.println();
	}
	
	static void printDiagonals(Node node) {
		
		Map<Integer, ArrayList<Integer>> map = new HashMap();
		
		diagonals(node, map, 0);
		
		for (int key: map.keySet()) {
			
			System.out.println(" d =  " + key + " Keys "  + map.get(key));
		}
		
		
	}
	
	static void diagonals(Node node, Map<Integer, ArrayList<Integer>> map, int d) {
		
		if ( node != null) {
			ArrayList<Integer> list = map.get(d);
			if ( list == null)
				list = new ArrayList<Integer>();
			list.add(node.data);
			map.put(d, list);
			
			diagonals(node.left, map, d+1);
			diagonals(node.right, map, d);
			
		}
	}
	
	static void diagonalsIterative (Node root) {
		
		int d =0;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		
		System.out.print(" d = " + d +" keys = ");
		Node node = null;
		
		while ( !queue.isEmpty() ) {
			node = queue.poll();
			
			if ( null == node) {
				
				if ( queue.size() > 0 )
					queue.add(null);
				d++;
				System.out.println();
				System.out.print(" d = " + d +" keys = ");

			} else {
				
				while ( node != null) {
					System.out.print(node.data + " ");
					if ( node.left != null)
						queue.add(node.left);
					node = node.right;
				}
			}
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
