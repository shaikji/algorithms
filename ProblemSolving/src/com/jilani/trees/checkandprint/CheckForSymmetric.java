package com.jilani.trees.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class CheckForSymmetric {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);


		System.out.println(" Is identical? " + isMirror(root.left, root.right));
		
		System.out.println(" Is Identical? " + isMirrorIterative(root));
		

	}

	static boolean isMirror(Node root, Node root2){

		if (root == null && root2 == null)
			return true;

		if (root == null || root2 == null)
			return false;

		return root.data == root2.data && isMirror(root.left, root2.right) && isMirror(root.right, root2.left);
	}
	
	static boolean isMirrorIterative(Node root) {
		
		if ( root == null)
			return true;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root.left);
		q.add(root.right);
		Node t1 = null;
		Node t2 = null;
		
		while( q.size() > 0  ) {
			t1 = q.poll();
			t2 = q.poll();
			
			if ( t1 == null && t2 == null) 
				continue;
			
			if ( t1 == null || t2 == null)
				return false;
	
			if ( t1.data != t2.data)
				return false;
			
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		
		return true;
	}
	


	static Node root;
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
