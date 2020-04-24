package com.jilani.trees.checkandprint;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckForIdenticalTrees {

	public static void main(String[] args) {

		root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);

		root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);

		System.out.println(" Is identical? " + isIdentical(root1, root2));
		
		System.out.println(" Is Identical? " + isIdenticalIterative(root1, root2));
		
		System.out.println(" Is Identical? " + isIdenticalLevel(root1, root2));

	}

	static boolean isIdentical(Node root1, Node root2) {

		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		return root1.data == root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);

	}
	
	static boolean isIdenticalIterative(Node root1, Node root2) {
		
		if ( root1 == null && root2 == null)
			return true;
		
		Node node1 = root1;
		Stack<Node> stack1 = new Stack();
		
		Node node2 = root2;
		Stack<Node> stack2 = new Stack();
		
		
		
		while ( true ) {
			while ( node1 != null) {
				stack1.push(node1);
				node1 = node1.left;
			}	
			
			while ( node2 != null) {
				stack2.push(node2);
				node2 = node2.left;
			}
			if ( stack1.isEmpty()  && stack2.isEmpty() )
				break;
			
			if ( stack1.isEmpty() || stack2.isEmpty())
				return false;
			
			
			node1 = stack1.pop();
			node2 = stack2.pop();
			
			if ( node1.data != node2.data)
				return false;
			
			node1 = node1.right;
			node2 = node2.right;
		}
		
		return true;
	}
	
	static boolean isIdenticalLevel(Node root1, Node root2) {
		
		if ( root1 == null && root2 == null)
			return true;
		
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		Node t1 = null;
		Node t2 = null;
		
		q1.add(root1);
		q2.add(root2);
		
		while ( q1.size() > 0  && q2.size() > 0 )  {
			
			t1 = q1.poll();
			t2 = q2.poll();
			
			if (t1.data != t2.data)
				return false;
			
			if ( (t1.left == null && t2.left != null) ||
					(t1.right == null && t2.right != null) )
				return false;
			
			if ( t1.left != null)
				q1.add(t1.left);
			
			if ( t1.right != null)
				q1.add(t1.right);
			
			if ( t2.left != null)
				q2.add(t2.left);
			
			if ( t2.right != null)
				q2.add(t2.right);
		}
		
		return q1.isEmpty() && q2.isEmpty();
	}

	static Node root1;
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
