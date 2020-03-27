package com.jilani.stacks;

import java.util.Stack;

public class DeleteElements {

	public static void main(String[] args) {
		
		//int[] arr = {20, 10, 25, 30, 40};
		int[] arr =  { 23, 45, 11, 77, 18};
		int k = 3;
		
		deleteKElements(arr, k);

	}
	
	static void deleteKElements( int[] arr, int k) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(arr[0]);
		int count =0;
		
		for ( int i=1; i < arr.length; i++) {
			while ( !stack.isEmpty() && count < k && stack.peek() < arr[i]) {
				count++;
				stack.pop();
			}
			stack.push(arr[i]);
		}
		
		int[] newArr = new int[stack.size()];
		for ( int i= newArr.length-1; i >=0; i--) {
			newArr[i] = stack.pop();
		}
		
		for ( int i=0; i < newArr.length; i++) {
			System.out.print(newArr[i]+" ");
		}
		System.out.println();
	}

}
