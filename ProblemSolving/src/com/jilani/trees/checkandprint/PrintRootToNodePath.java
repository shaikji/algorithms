package com.jilani.trees.checkandprint;

public class PrintRootToNodePath {

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
		
		printPath(root, root.right.right.left.left);
		System.out.println();
		printPath2(root,  root.right.right.left.left);
	}
	
	static void printPath( Node root, Node node) {
	
		if ( root == null)
			return;
		
		int path[] = new int[100];
		
		printPathsUtil(root, path, 0, node);
	}
	
	static void printPath2( Node root, Node node) {
		
		if ( root == null)
			return;
		
		int path[] = new int[100];
		
		printPathsUtilV2(root, path, 0, node);
	}
	
	static void printPathsUtil(Node root, int[] path, int pathlen, Node node) {
		
		if( root == null) {
			return;
		}
		
		path[pathlen++] = root.data;
		
		printPathsUtil(root.left, path, pathlen, node);
		
		if ( root == node) {
			print(path, pathlen);
			return;
		}		
		printPathsUtil(root.right, path, pathlen, node);
	}

	
	/* pre order */
	
	static boolean printPathsUtilV2(Node root, int[] path, int pathlen, Node node) {
		
		if( root == null) {
			return false;
		}
		
		path[pathlen++] = root.data;
		
		if ( root == node) {
			print(path, pathlen);
			return true;
		}		

		return printPathsUtilV2(root.left, path, pathlen, node) || printPathsUtilV2(root.right, path, pathlen, node);
	}

	static void print(int[] path, int pathlen) {
		for ( int i=0; i < pathlen; i++)
			System.out.print(" "+ path[i]);
		System.out.println();
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
