package com.jilani.trees;

public class PrintPostOrderFromInOrderAndPreOrder {
	
	static int index =0;

	public static void main(String[] args) {

		int[] in = {4,2,5,1,3,6};
		int[] pre = {1,2,4,5,3,6};

		printPostorder(in, pre);

	}

	static void printPostorder(int[] in, int[] pre) {

		if (in == null || pre == null || in.length == 0 || pre.length == 0)
			return;

		post(in, pre, 0, in.length - 1);
		System.out.println();

	}

	static void post(int[] in, int[] pre, int start, int end) {

		if ( index >= in.length)
			return;
		
		if (start == end) {
			System.out.print(" " + pre[index]);
			return;
		}

		int i = findIndex(in, pre[index]);
		index++;
		post(in, pre, start, i - 1);
		index++;
		post(in, pre, i + 1, end);
		System.out.print(" " + in[i]);

	}
	
	static private int findIndex(int[] in, int elem) {
		
		for ( int i=0; i < in.length; i++)
		{
			if ( in[i] == elem ) {
				return i;
			}
		}
		return -1;
	}

}
