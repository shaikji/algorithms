package com.jilani.trees;

import java.util.ArrayList;

public class ReplaceNodeWithInorderPredecessorNSuccessor {

	public static void main(String[] args) {
		
	    root = new Node(1);       		//         1         
	    root.left = new Node(2);        //       /   \       
	    root.right = new Node(3);       //     2      3      
	    root.left.left = new Node(4);  //    /  \  /   \    
	    root.left.right = new Node(5); //   4   5  6   7    
	    root.right.left = new Node(6); 
	    root.right.right = new Node(7); 

	    preorder(root);
	    
	    replace(root);
	    
	    System.out.println(" After replacing");
	    preorder(root);
	}
	
	static void replace(Node node) {
		if ( node == null)
			return;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		storeInorderTraversal(node, list);
		list.add(0);
		Index index = new Index(1);
		replaceNodeWithSum(node, list, index);
	}
	
	static void replaceNodeWithSum(Node node, ArrayList<Integer> list, Index index) {
		if ( node != null) {
			replaceNodeWithSum(node.left, list, index);
			int i = index.index;
			node.data =  list.get(i-1) + list.get(i+1);
			index.index = i + 1;
			replaceNodeWithSum(node.right, list, index);
		}
	}
	
	static void storeInorderTraversal(Node node, ArrayList<Integer> list) {
		
		if ( node != null) {
			storeInorderTraversal(node.left, list);
			list.add(node.data);
			storeInorderTraversal(node.right, list);
			
		}
	}
	
	static class Index{
		int index;
		Index(int index){
			this.index = index;
		}
	}
	
	static void preorder(Node root) {
		if (root != null) {
			System.out.println(root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	static Node root;
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
		}
	}

}
