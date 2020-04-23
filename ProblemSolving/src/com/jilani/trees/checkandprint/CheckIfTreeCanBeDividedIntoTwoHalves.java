package com.jilani.trees.checkandprint;

public class CheckIfTreeCanBeDividedIntoTwoHalves {

	public static void main(String[] args) {

		root = new Node(5);
		root.left = new Node(1);
		root.left.left = new Node(3);
		root.right = new Node(6);
		root.right.left = new Node(7);
		root.right.right = new Node(4);

//		root = new Node(5);
//		root.left = new Node(1);
//		root.right = new Node(6);
//		root.right.left = new Node(7);
//		root.right.right = new Node(4);
//		root.right.left.left = new Node(3);
//		root.right.left.right = new Node(2);
//		root.right.right.right = new Node(8);
		
		System.out.println(" Can be divided into two halves? = " + canBeDivided(root));
		System.out.println(" Can be divided into two halves? = " + canBeDividedRec(root));

	}
	
	static boolean canBeDivided(Node root) {
		
		int treeSize = count(root);
		
		return checkUtil(root, treeSize);
		
		
	}
	
	static boolean canBeDividedRec(Node root) {
		
		int treeSize = count(root);
		
		//return checkUtil(root, treeSize);
		
		return checkUtil(root, treeSize, new Res(0));
		
	}
	
	static boolean checkUtil( Node root, int tsize, Res res) {
		
		if ( root == null ) {
			return false;
		}
		if ( root.left == null && root.right == null) {
			res.size = 1;
			return (tsize-res.size == res.size);
		}
		Res leftRs = new Res(0);
		Res rightRs = new Res(0);
		
		boolean left = checkUtil(root.left, tsize, leftRs);
		if ( left)
			return true;
		
		boolean right = checkUtil(root.right, tsize, rightRs);
		
		if ( right )
			return true;
		
		res.size = 1 + leftRs.size + rightRs.size;
		return (tsize-res.size == res.size);
	}
	
	static class Res{
		int size;
		Res(int size){
			this.size = size;
		}
	}
	
	static boolean checkUtil( Node root, int totalSize) {
		
		if ( root == null)
			return false;
		
		int count = count(root);
		if ( count == totalSize - count) {
			return true;
		}
		
		boolean left = checkUtil(root.left, totalSize);
		if ( left )
			return left;
		
		return checkUtil(root.right, totalSize);
	}
	
	
	static int count(Node node) {
		
		if ( node == null)
			return 0;
		return 1 + count(node.left) + count(node.right);
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
