package com.jilani.trees.summation;

import java.util.Stack;

public class MergeTwoBinaryTreesIntoNewTree {

	public static void main(String[] args) {

		root1 = new Node(2);
		root1.left = new Node(1);
		root1.right = new Node(4);
		root1.left.left = new Node(5);

		root2 = new Node(3);
		root2.left = new Node(6);
		root2.right = new Node(1);
		root2.left.right = new Node(2);
		root2.right.right = new Node(7);

		//root1 = merge(root1, root2);

		root3 = mergeIterative(root1, root2);
		inorder(root3);
		System.out.println();
		preorder(root3);
	}

	static void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}

	static void preorder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}
//	
//	
//	static Node merge(Node root1, Node root2) {
//		
//		int data = 0;
//		
//		if ( root1 == null && root2 == null)
//			return null;
//		
//		if ( root1 != null)
//			data += root1.data;
//		
//		if (root2 != null)
//			data += root2.data;
//		
//		Node node = new Node(data);
//
//		node.left = merge( root1 != null ? root1.left: null, root2 != null ? root2.left : null);
//		node.right = merge( root1 != null ? root1.right: null, root2 != null ? root2.right : null);
//
//		return node;
//	}

	static Node merge(Node root1, Node root2) {

		if (root1 == null)
			return root2;

		if (root2 == null)
			return root1;

		root1.data += root2.data;

		root1.left = merge(root1.left, root2.left);
		root1.right = merge(root1.right, root2.right);
		return root1;
	}
	
	
	static Node mergeIterative (Node root1, Node root2) {
		
		if ( root1 == null)
			return root2;
		
		if ( root2 == null)
			return root1;
		
		Pair p = new Pair(root1, root2);
		
		Stack<Pair> stack = new Stack<Pair>();
		stack.push(p);
		
		Pair temp = null;
		
		while ( !stack.isEmpty() ) {
			temp = stack.pop();
			
			if ( temp.l == null || temp.r == null) {
				continue;
			}
			
			temp.l.data += temp.r.data;
			
			if ( temp.l.left == null) {
				temp.l.left = temp.r.left;
			} else {
				Pair t = new Pair();
				t.l = temp.l.left;
				t.r = temp.r.left;
				stack.push(t);
			}
			
			if ( temp.l.right == null) {
				temp.l.right = temp.r.right;
			} else {
				Pair t = new Pair();
				t.l = temp.l.right;
				t.r = temp.r.right;
				stack.push(t);
			}
		}
		
		return root1;
		
	}
	
	static class Pair{
		Node l;
		Node r;
		Pair (){
			this.l = null;
			this.r = null;
		}
		Pair(Node l, Node r){
			this.l = l;
			this.r = r;
		}
	}

	static Node root1;
	static Node root2;
	static Node root3;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
}
