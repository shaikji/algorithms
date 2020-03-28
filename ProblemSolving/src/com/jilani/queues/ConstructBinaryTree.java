package com.jilani.queues;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTree {

	public static void main(String[] args) {

		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		
		root = constructTree(head);
		inorder(root);
	}
	
	static Node constructTree(ListNode head) {
		
		if ( head == null)
			return null;
		
		ListNode curr = head;
		Queue<Node> queue = new LinkedList<Node>();
		Node newroot = new Node(curr.data);
		queue.add(newroot);
		Node node;
		
		while ( curr != null) {
			node = queue.poll();
			
			if ( curr.next == null)
				break;
			node.left = new Node(curr.next.data);
			
			curr = curr.next;
			
			if ( curr.next == null)
				break;
			node.right = new Node(curr.next.data);
				
			queue.add(node.left);
			queue.add(node.right);
			
			curr = curr.next;
		}
		
		return newroot;
	}

	static ListNode head;
	static Node root;
	
	static class ListNode{
		int data;
		ListNode next;
		ListNode(int data){
			this.data = data;
		}
	}
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	static void inorder( Node root) {
		if ( root != null) {
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
}
