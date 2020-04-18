package com.jilani.trees;

public class FindDepthOfFullBinaryTreeFromGivenPreorder {

	public static void main(String[] args) {

		char[] arr = { 'I', 'I', 'L', 'L', 'I','I','L','L','I','L','L' };
	
		INT index = new INT(0);
		System.out.println(" depth = " + depth(arr, index));

		
	}
	
	static class INT{
		int index;
		INT(int index){
			this.index = index;
		}
	}

	static int depth(char[] arr, INT index) {
		int i= index.index;
		if (i >= arr.length || arr[i] == 'L')
			return 0;

		index.index++;
		int ld = depth(arr, index);
		index.index++;
		int rd = depth(arr, index);

		return 1 + Math.max(ld, rd);

	}

}
