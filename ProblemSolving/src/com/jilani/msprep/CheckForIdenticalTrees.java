package com.jilani.msprep;

public class CheckForIdenticalTrees {

	public static void main(String[] args) {

	 	root1 = new Node(1); 
        root1.left = new Node(2); 
        root1.right = new Node(3); 
        root1.left.left = new Node(4); 
        root1.left.right = new Node(5); 
   
        root2 = new Node(1); 
        root2.left = new Node(2); 
        root2.right = new Node(3); 
        root2.left.left = new Node(4); 
        root2.left.right = new Node(5); 
        
        System.out.println(" Are Identical = " + areIdentical(root1, root2));
	}
	
	static boolean areIdentical ( Node root1, Node root2) {
		
		if ( root1 == null && root2 == null)
			return true;
		
		if ( root1 == null || root2 == null)
			return false;
		
		return (root1.data == root2.data)
				&& areIdentical(root1.left, root2.left) 
				&& areIdentical(root1.right, root2.right);
	}
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
		}
	}
	
	static Node root1, root2;

}
