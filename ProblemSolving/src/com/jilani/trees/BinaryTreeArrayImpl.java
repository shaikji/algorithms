package com.jilani.trees;

public class BinaryTreeArrayImpl {

	public static void main(String[] args) {
		BinaryTreeArrayImpl bt = new BinaryTreeArrayImpl(10);
		
		/*
		 * for ( int i=0;i <= 9; i++) { bt.insert((char) ('A' + i)); bt.printTree(); }
		 */
		
		bt.insert('A');
		bt.insertAtIndex(1,'B');
		bt.insertAtIndex(2,'C');
		bt.insertToTheLeftOfIndex(1, 'D');
		bt.insertToTheRightOfIndex(1, 'E');
		bt.insertToTheLeftOfIndex(2, 'F');
		bt.insertToTheRightOfIndex(2, 'G');
		bt.printTree();

	}
	
	char[] tree;
	int size = 0;

	public BinaryTreeArrayImpl(int size) {
		this.size = size;
		tree = new char[size];
		for ( int i=0; i < size; i++)
			tree[i] ='*';
	}
	
	void insertAtIndex(int index, char elem) {
		if ( index < size) {
			tree[index]= elem;
		}
	}
	
	void insertToTheLeftOfIndex(int index, char elem) {
		if ( 2 * index + 1  < size) {
			tree[2 * index + 1 ]= elem;
		}
	}
	
	void insertToTheRightOfIndex(int index, char elem) {
		if ( 2 * index + 2  < size) {
			tree[2 * index + 2 ]= elem;
		}
	}
	
	
	void insert(char elem) {
		
		for ( int i=0; i < size; i++)
		{
			if ( tree[i] == '*') {
				tree[i] = elem;
				break;
			}
			
		}
	}
	
	void printTree() {
		
		for ( int i=0; i < size; i++) {
			System.out.print(tree[i] + " ");
		}
		System.out.println();
	}
	
	

}
