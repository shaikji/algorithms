package com.jilani.trees.checkandprint;

import java.util.ArrayList;

public class PrintAllRootToLeafPathsWithTheirRelativePosition {

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

/*		root.left.left.left.left = new Node(16);
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
*/		
		printPaths(root);
	}
	
	static void printPaths( Node root) {
	
		if ( root == null)
			return;
		
		ArrayList<PATH> path= new ArrayList();
		int hd = 0;
		int order = 0;
		printPathsUtil(root, path, hd, order);
	}
	
	static void printPathsUtil(Node root, ArrayList<PATH> path,int hd, int order) {
		
		if( root == null) {
			return;
		}
		path.add(new PATH(hd, root.data));
		
		if ( root.left == null && root.right == null) {
			print(path);
			path.remove(path.size()-1);
			return;
		}
		printPathsUtil(root.left, path, hd-1, order+1);
		printPathsUtil(root.right, path, hd+1, order+1);
		path.remove(path.size()-1);
	}
	
	static void print(ArrayList<PATH> path) {
		
		int min_hd = Integer.MAX_VALUE;
		
		for ( PATH p : path) {
			//System.out.print(" ( " + p.hd + " " + p.data + " )  ");
			if (p.hd < min_hd) {
				min_hd = p.hd;
			}
		}
		
		
		for ( PATH p: path) {
			
			int numUnderScores = Math.abs(p.hd - min_hd);
			for ( int i=0; i< numUnderScores; i++)
				System.out.print(" _ ");
			System.out.println(p.data);
		}
		System.out.println();
	}
	
	static class PATH{
		int hd;
		int data;
		
		PATH(int hd, int data){
			this.hd = hd;
			this.data = data;
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
