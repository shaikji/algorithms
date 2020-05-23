package com.jilani.arrays;

public class MoveAllZerosToEnd {

	public static void main(String[] args) {

		int[] arr = {0, 1, 9, 8, 4, 0, 0, 2, 
                7, 0, 6, 0, 9};
		int n = arr.length;
		
		printArray(arr, n);
		//usingCount(arr, n);
		//usingCountSingleLoop(arr, n);
		usingTwoPointerApproach(arr, n);
		printArray(arr, n);
		
		
		
	}
	
	
	static void usingTwoPointerApproach(int[] arr, int n) {
		
		
		int j=0;
		
		for ( int i=0; i < n; i++) {
			
			if ( arr[i] != 0 && arr[j] == 0 ) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
			if ( arr[j] != 0 )
				j++;
			
			
		}
		
	}

	
	
	static void usingCount(int[] arr, int n) {
		
		int count = 0;
		
		for ( int i=0; i < n; i++) {
			if ( arr[i] != 0 ) {
				arr[count++]= arr[i];
			}
		}
		
		while ( count < n )
			arr[count++]= 0;
		
	}
	
	static void usingCountSingleLoop( int[] arr, int n) {
		
		int count = 0;
		
		for ( int i=0; i < n; i++) {
			
			if ( arr[i] != 0 ) {
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				count++;
			}
		}
	}
	
	static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + "   ");
		System.out.println();
	}


}
