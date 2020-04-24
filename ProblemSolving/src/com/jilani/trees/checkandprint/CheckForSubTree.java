package com.jilani.trees.checkandprint;

import java.util.ArrayList;

public class CheckForSubTree {

	public static void main(String[] args) {

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.left.left.right = new Node(7);
		

		root_sub = new Node(2);
		root_sub.left = new Node(4);
		root_sub.right = new Node(5);
		root_sub.left.right = new Node(7);
		
		
		//System.out.println(" Is complete binary? " + isSubTree(root, root_sub));
		System.out.println(" Is complete binary? " + isSubTree(root, root_sub));
	}
	
	static boolean isSubTree(Node T, Node S) {
		
		if ( T == null)
			return S == null;
		
		ArrayList<Integer> inT = new ArrayList();
		ArrayList<Integer> inS = new ArrayList();
		ArrayList<Integer> preT = new ArrayList();
		ArrayList<Integer> preS = new ArrayList();
		
		collectInorder(T, inT);
		collectInorder(S, inS);
		collectPreorder(T, preT);
		collectPreorder(S, preS);
		
		return isSubList(inT, inS) && isSubList(preT, preS);
	}
	
	static boolean isSubList(ArrayList<Integer> list1 , ArrayList<Integer> list2) {
		
		int i =0;
		for ( ; i < list1.size(); i++)
			if ( list1.get(i) == list2.get(0))
				break;
		int j=0;
		i++;
		j++;
		while (i < list1.size() && j < list2.size()) {
			
			if ( list1.get(i) != list2.get(j))
				return false;
			i++;
			j++;
		}
		
		return true;
	}
	
	static void collectInorder(Node node, ArrayList<Integer> list) {
		
		if( node != null) {
			collectInorder(node.left, list);
			list.add(node.data);
			collectInorder(node.right, list);
		}
	}
	
	static void collectPreorder(Node node, ArrayList<Integer> list) {
		
		if( node != null) {
			list.add(node.data);
			collectPreorder(node.left, list);
			collectPreorder(node.right, list);
		}
	}
	
	static boolean isSubTreeV1 (Node T, Node S) {
		
		if ( T == null) {
			return S == null;
		}
		
		return areIdentical(T, S) || isSubTree(T.left, S) || isSubTree(T.right, S);
	}
	
	static boolean areIdentical ( Node T1, Node T2) {
		
		if ( T1 == null && T2 == null)
			return true;
		
		if ( T1 == null || T2 == null)
			return false;
		
		return (T1.data == T2.data) && areIdentical(T1.left, T2.left) && areIdentical(T1.right, T2.right);
	}

	static Node root;
	static Node root_sub;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}
}
