package com.jilani.msprep;

public class ArraySort012 {

	public static void main(String[] args) {

		int[] arr = { 0,1,2,2,1,0,0,0,2,2,1,1};
	
		printArray(arr,arr.length,"Before sorting");
		sort(arr, arr.length);
		printArray(arr,arr.length,"After sorting");
	
	}
	
	static void sort( int[] arr, int n) {
		
		if ( arr == null || n <= 0)
			return;
		
		int l = 0;
		int r = n-1;
		int mid = 0;
		
		while ( mid <= r) {
			
			switch(arr[mid]) {
			case 0: 
				swap(arr, l, mid);
				l++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr, mid, r);
				r--;
				break;
			}
		}
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void printArray(int[] arr, int n, String msg) {
		System.out.println(msg);
		if (arr == null || n<= 0)
			System.out.println("Array is empty");
		
		for ( int i=0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	

}
