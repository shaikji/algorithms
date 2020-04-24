package com.jilani.trees.checkandprint;

import java.util.LinkedList;
import java.util.Queue;

public class CheckForRootToLeafPath {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);


		int[] arr = {1,2 };
		
		System.out.println(" has root to leaf path? " + hasPath(root,arr, 0));
		
	}

	static boolean hasPath(Node root,int[] arr, int index){

		if ( root == null || index < arr.length ) {
			return index == arr.length;
		}
		int i = index;
		index++;
		return root.data == arr[i] && (hasPath(root.left, arr, i+1) || hasPath(root.right, arr, i+1));
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
