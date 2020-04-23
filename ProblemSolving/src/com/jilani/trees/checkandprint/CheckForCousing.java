package com.jilani.trees.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class CheckForCousing {

	public static void main(String[] args) {

		root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(40);
		root.left.left = new Node(30);
		root.left.right = new Node(100);
		root.left.right.left = new Node(25);
		root.left.right.right = new Node(25);
		root.right.left = new Node(50);
		
		//Node n1 = root.left.left;
		//Node n2 = root.right.left;

		Node n1 = root.left.left;
		Node n2 = root.right.left;

		System.out.println(" Are cousins =  " + areCousinsRec(root, n1, n2));
		//System.out.println(" getLevel = " + getLevel(root,0, root.right.left));
	}
	
	
	//Recursive
	
	static boolean areCousinsRec ( Node root, Node n1, Node n2) {
		
		if ( root == null)
			return false;
		
		if ( getLevel(root, 0, n1) != getLevel(root, 0, n2))
			return false;
		return !isSibling(root, n1, n2);
	}
	
	static boolean isSibling (Node root, Node n1, Node n2) {
		if ( root == null)
			return false;
		
		if ((root.left == n1 && root.right == n2) || (root.left == n2 && root.right == n1) )
			return true;
		
		return isSibling(root.left, n1, n2) || isSibling ( root.right, n1, n2);
	}
	
	static int getLevel( Node root, int level, Node node) {
		if (root == null)
			return 0;
		
		if ( root == node)
			return level;
		
		int l = getLevel(root.left, level+1, node);
		if	 ( l == 0 )
			return getLevel(root.right, level +1, node);
		
		return l;
	}
	
	// Not very clean
	static boolean areCousins(Node root, Node n1, Node n2) {
		
		if( root == null)
			return false;
		
		Node curr = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(curr);
		queue.add(null);
		Node temp = null;
		Node parent1 = null;
		Node parent2 = null;
		
		while ( !queue.isEmpty()) {
			
			temp = queue.poll();
			
			if ( temp == null) {
				
				if ( !queue.isEmpty()) {
					queue.add(null);
				}
				
				// Check if both the nodes are found and their parents are collected.
				if ( parent1 != null && parent2 != null) {
					return true;
				} else if ( parent1 == null && parent2 == null) {
					continue;
				} else {
					return false;
				}
				
			} else {
				
			
				if ( (temp.left == n1 && temp.right == n2) || (temp.left == n2 && temp.right == n1)) {
					return false;
				}
				
				if ( temp.left == n1 )
					parent1 = temp;
				
				if ( temp.left == n2)
					parent2 = temp;
				
				if ( temp.right == n1)
					parent1 = temp;
				
				if ( temp.right == n2 )
					parent2 = temp;
				
				if (temp.left != null)
					queue.add(temp.left);
				
				if ( temp.right != null)
					queue.add(temp.right);
				
			}
			
		}
		
		return false;
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
