package com.jilani.trees;

public class FillInorderSuccessor {

	public static void main(String[] args) {
		
	    root = new Node(1);       		//         1         
	    root.left = new Node(2);        //       /   \       
	    root.right = new Node(3);       //     2      3      
	    root.left.left = new Node(4);  //    /  \  /   \    
	    root.left.right = new Node(5); //   4   5  6   7    
	    root.right.left = new Node(6); 
	    root.right.right = new Node(7); 

	    preorder(root);
	    
	    fillInorderSuccessor(root);
	    
	    System.out.println(" After filling");
	    preorder(root);
	}
	
	static Node successor = null;
	
	static void fillInorderSuccessor(Node node) {
		if ( node == null)
			return;
		
		fillInorderSuccessor(node.right);
		node.next = successor;
		successor = node;
		fillInorderSuccessor(node.left);
		
	}
	
	
	static void preorder(Node root) {
		if (root != null) {
			System.out.println(root.data + " " + getNext(root));
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	static int getNext(Node root) {
		if ( root == null || root.next == null)
			return -1;
		return root.next.data;
	}
	
	static Node root;
	
	static class Node{
		int data;
		Node next;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
		}
	}

}
