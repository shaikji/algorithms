package com.jilani.queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigzagTreeTraversal {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		printZigzag(root);
		System.out.println();
		printZigzagUsingTwoStacks(root);
		
	}
	
	static void printZigzag(Node root) {
		
		if ( root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		Node node;
		boolean flag = false;
		Stack<Node> stack = new Stack();
		while ( !queue.isEmpty()) {
	
			node = queue.poll();
			
			if ( node == null) {
				if (flag) {
					System.out.println();
					while ( !stack.isEmpty())
						System.out.print(stack.pop().data+ " ");
					System.out.println();
				}
				if ( !queue.isEmpty())
					queue.add(null);
				flag = !flag;
			} else {
				if (flag) {
					stack.push(node);
				} else {
					System.out.print(node.data+ " ");
				}
				if ( node.left != null)
					queue.add(node.left);
				if ( node.right != null)
					queue.add(node.right);
			}
		}
		
	}
	
	static void printZigzagUsingTwoStacks(Node root) {
		
		if ( root == null)
			return;
		
		Stack<Node> currLevel = new Stack<Node>();
		Stack<Node> nextLevel = new Stack<Node>();
		boolean leftToRight = true;
		
		currLevel.add(root);
		Node node;
		
		while ( !currLevel.isEmpty() ) {
			
			node = currLevel.pop();
			System.out.print(" " + node.data);
			
			if ( leftToRight) {
				if ( node.left != null)
					nextLevel.push(node.left);
				if ( node.right != null)
					nextLevel.push(node.right);
			} else {
				if ( node.right != null)
					nextLevel.push(node.right);
				if ( node.left != null)
					nextLevel.push(node.left);
			}
			
			if ( currLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<Node> temp = currLevel;
				currLevel = nextLevel;
				nextLevel = temp;
				System.out.println();
			}
			
		}
	}
	
	static Node root;

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

}
