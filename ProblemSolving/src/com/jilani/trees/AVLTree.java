package com.jilani.trees;

public class AVLTree {

	public static void main(String[] args) {
		
		for ( int i=10; i >= 0; i--) {
			insert(i);
			System.out.println();
			System.out.print("IN ORDER: ");
			inorder(root);
			
			System.out.println();
			System.out.print("PRE ORDER: ");
			preorder(root);
			
			System.out.println();
			System.out.print("POST ORDER: ");
			postorder(root);
			
			System.out.println();
		}
		
	}
	
	static void insert(int elem) {
		root = avl_insert(elem, root);
	}
	
	static AVLNode avl_insert( int elem, AVLNode root) {
		
		if ( root == null)
			return new AVLNode(elem);
		
		if ( elem < root.data)
			root.left = avl_insert(elem, root.left);
		else 
			root.right = avl_insert(elem, root.right);
		
		int lh = height(root.left);
		int rh = height(root.right);
		int balanceFactor = lh - rh;
		
		if ( balanceFactor == 2 ) {
			if ( elem < root.left.data)
				root = LLImbalanceRotateRight(root);
			else 
				root = LRImbalanceRotateRL(root);
		} else if ( balanceFactor == -2) {
			if ( elem > root.right.data)
				root = RRImbalanceRotateLeft(root);
			else 
				root = RLImbalanceRotateLR(root);
		}
		
		root.h = 1 + Math.max(height(root.left), height(root.right));
		return root;
	}
	
	
	// Left Left Imbalance - Rotate Right
	
	static AVLNode LLImbalanceRotateRight ( AVLNode k2) {
		
		AVLNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		
		k2.h = 1 + Math.max(height(k2.left), height(k2.right));
		k1.h = 1 + Math.max(height(k1.left), height(k1.right));
		return k1;
	}
	
	static AVLNode LRImbalanceRotateRL( AVLNode k3) {
		k3.left = RRImbalanceRotateLeft(k3.left);
		return LLImbalanceRotateRight(k3);
	}
	

	static AVLNode RLImbalanceRotateLR( AVLNode k3) {
		k3.right = LLImbalanceRotateRight(k3.right);
		return RRImbalanceRotateLeft(k3);
	}
	

	// Right Right Imbalance - Rotate Left
	
	static AVLNode RRImbalanceRotateLeft ( AVLNode k2) {
		
		AVLNode k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		
		k2.h = 1 + Math.max(height(k2.left), height(k2.right));
		k1.h = 1 + Math.max(height(k1.left), height(k1.right));
		return k1;
	}
	
	
	
	static int height(AVLNode node) {
		return node == null? -1: node.h;
	}
	
	
	static void inorder(AVLNode node) {
		if ( node != null) {
			inorder(node.left);
			System.out.print(node.data+ " ");
			inorder(node.right);
		}
	}
	
	static void preorder(AVLNode node) {
		if ( node != null) {
			System.out.print(node.data+ " ");
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	static void postorder(AVLNode node) {
		if ( node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data+ " ");
		}
	}
	
	
	
	
	static AVLNode root;
	static class AVLNode{
		
		int data;
		AVLNode left;
		AVLNode right;
		int h; // Height
		
		AVLNode(int data){
			this.data = data;
			h = 0;
		}
	}	
}
