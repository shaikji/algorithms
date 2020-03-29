package com.jilani.queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountSiblingsInNaryTree {

	public static void main(String[] args) {
		
		root = new Node(50);
		
		root.addChild(2);
		root.getChild(0).addChild(15);
		root.getChild(0).addChild(25);
		root.getChild(0).getChild(1).addChild(70);
		root.getChild(0).getChild(1).addChild(100);
		
		root.addChild(30);
		root.getChild(1).addChild(6);
		root.getChild(1).addChild(1);
		
		
		root.addChild(14);
		root.getChild(2).addChild(7);
		root.getChild(2).getChild(0).addChild(17);
		root.getChild(2).getChild(0).addChild(99);
		root.getChild(2).getChild(0).addChild(27);

		root.addChild(60);
		root.getChild(3).addChild(16);
		
		
		System.out.println("Number of siblings for 27 = "+ numSiblings(root, 27));
		System.out.println("Number of siblings for 16 = "+ numSiblings(root, 16));
		System.out.println("Number of siblings for 2 = "+ numSiblings(root,2));
		System.out.println("Number of siblings for 50 = "+ numSiblings(root,50));
			
	}
	
	static int numSiblings(Node node, int elem) {
		
		if ( node == null || node.data == elem)
			return 0;
		
		Queue<Node> queue = new LinkedList();
		queue.add(node);
		Node curr;
		while ( !queue.isEmpty()) {
			curr = queue.poll();
			
			ArrayList<Node> children = curr.getAllChidren();
			for ( int i=0; i < children.size(); i++) {
				if ( children.get(i).data == elem) {
					return children.size()-1;
				} 
				queue.add(children.get(i));
			}
		}
		return 0;
	}
	
	static Node root;
	
	static class Node{
		int data;
		ArrayList<Node> children;
		
		Node(int data){
			this.data = data;
			children = new ArrayList();
		}
		
		void addChild(int data){
			children.add(new Node(data));
		}
		
		Node getChild(int index) {
			return children.get(index);
		}
		
		ArrayList<Node> getAllChidren(){
			return children;
		}
	}

}
