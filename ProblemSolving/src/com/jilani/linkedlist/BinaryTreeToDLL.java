package com.jilani.linkedlist;

public class BinaryTreeToDLL {

	
	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		treeToDll(root);
		printDLL(start, "DLL");
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
