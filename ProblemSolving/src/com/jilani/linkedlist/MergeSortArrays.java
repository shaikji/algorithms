package com.jilani.linkedlist;

public class MergeSortArrays {

	public static void main(String[] args) {
		
		//int[] arr = { 10,20,40,30, 15,5};
		//int[] arr = { 5,4,3,2,1};
		int[] arr = {1,2,3,4,5};
		
		mergeSort(arr, 0, arr.length-1);
		
		printArray(arr,arr.length);

	}
	
	private static void printArray(int[] arr, int length) {
		
		for ( int i=0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
	}

	static void mergeSort(int[] arr, int l, int r) {
		
		if ( l < r ) {
			
			int mid = ( l + r )/2;
			
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merge(arr, l, mid, r);
		}
	}
	
	static void merge(int[] arr, int l, int mid, int r) {
			
		// Create two temporary arrays and start merging into the main array
		
		int[] temp1 = new int[mid-l+1];
		
		int index = l;
		
		for ( int i=0; i < temp1.length; i++) {
			temp1[i] = arr[index++];
		}
		
		int[] temp2 = new int[r-mid];
		
		for ( int i =0; i < temp2.length; i++) {
			temp2[i] = arr[index++];
		}
		
		
		// Start merging
		
		index = l;
		
		int i = 0, j=0;
		
		while ( i < temp1.length && j < temp2.length) {
			
			if ( temp1[i] <= temp2[j] ) {
				arr[index] = temp1[i];
				i++;
				index++;
			} else {
				arr[index] = temp2[j];
				j++;
				index++;
			}
		}
		
		while ( i < temp1.length) {
			arr[index++] = temp1[i++];
		}
		
		while ( j < temp2.length) {
			arr[index++] = temp2[j++];
		}
		
	}

}
