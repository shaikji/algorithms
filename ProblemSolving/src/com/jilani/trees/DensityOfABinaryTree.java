package com.jilani.trees;

public class DensityOfABinaryTree {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		double density = density(root);
		System.out.println(" Density =  " + density);
	}
	
	static double density(Node root) {
		
		if ( null == root )
			return 0;
		Density hs = findDensity(root);
		return (double)hs.size/hs.height;
	}
	
	static Density findDensity ( Node node) {
		
		if ( node == null) {
			return new Density(0, 0);
		} 
		
		if ( node.left == null && node.right == null) {
			return new Density(1,1);
		}
		
		Density ld = findDensity(node.left);
		Density rd = findDensity(node.right);
		
		return new Density( 1 + Math.max(ld.height , rd.height), 1 + ld.size + rd.size);
		
	}
	
	static class Density {
		int height;
		int size;

		Density(int height, int size){
			this.height = height;
			this.size = size;
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
