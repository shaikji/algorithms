package com.jilani.queues;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	
	
	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		levelorder(root);
		
	}
	
	static void levelorder(Node root) {
		if ( root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		
		Node node;
		while ( !queue.isEmpty()) {
			node = queue.poll();
			System.out.println(node.data);
			
			if ( node.left != null)
				queue.add(node.left);
			if ( node.right != null)
				queue.add(node.right);
			
		}
	}

	static Node root;
	static class Node{
		Node left;
		Node right;
		int data;
		Node(int data){
			this.data = data;
		}
	}

}
