package com.jilani.linkedlist;

public class BinaryTreeToDLL {

	
	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);
		
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(10);
		root.right.left.right = new Node(11);
		
		//treeToDll(root);
		start = treeToDllSet1(root);
		printDLL(start, "DLL");
	}
	
	
	// Set 1 
	// Given a 'node',convert the left sub tree, find the inorder predicessor
	// Weave the inorder predecessor and node
	// Convert the right subtree
	// Weave the inorder successor and node
	// return the node.
	// Now from node go as left as possible to return the 'head' of the list.
	
	static Node treeToDllSet1 (Node root) {
		
		if ( root == null)
			return null;
		
		Node node = convertUtil(root);
		
		while ( node.left != null)
			node = node.left;
		return node;
	}
	
	static Node convertUtil ( Node root) {
		
		if ( root == null)
			return null;
		
		if ( root.left != null) {
			
			Node left = convertUtil ( root.left);
			
			for ( ; left.right != null; ) {
				left = left.right;
			}
			left.right = root;
			root.left = left;
		}
		
		if ( root.right != null) {
		
			Node right = convertUtil ( root.right);
			for ( ; right.left != null; ) {
				right = right.left;
			}
			right.left = root;
			root.right = right;
		}
		return root;
	}
	
	
	// just traverse in the inorder ( right to left )
	// and start building the list from end
	
	static void treeToDll( Node root) {
		
		if ( root == null)
			return;
		
		treeToDll(root.right);
		
		root.right = start;
		if ( start != null) {
			start.left = root;
		}
		start = root;
		treeToDll(root.left);
	}
	
	static void printDLL(Node start, String msg) {
		System.out.println(msg);
		
		if ( start == null)
			return;
		
		Node curr = start;
		
		while ( curr.right != null) {
			System.out.print(curr.data + " <-> ");
			curr = curr.right;
		}
		System.out.println(curr.data);
	}

	
	static Node root;
	static Node start;
	
	static class Node{
		Node left;
		Node right;
		int data;
		Node ( int data){
			this.data = data;
		}
	}
}
