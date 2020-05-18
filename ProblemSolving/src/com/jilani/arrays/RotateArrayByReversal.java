package com.jilani.arrays;

public class RotateArrayByReversal {

	public static void main(String[] args) {

		
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		int n = arr.length;
		int d = 2;
		
		RotateArrayByReversal rotate = new RotateArrayByReversal();
		
		System.out.println(" Original array ");
		rotate.printArray(arr);
		System.out.println();
		n = arr.length;
		d = 2;
		System.out.println(" N = " + n + " d = " + d );
		rotate.rotate(arr, n, d);
		System.out.println(" After rotation ");
		rotate.printArray(arr);
		System.out.println("\n\n");
	}
	
	// i - start index, j - end index
	void reverse( int[] arr, int i, int j) {
		
		while ( i < j ) {
			
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	
	void rotate( int[] arr, int n, int d) {
		
		// to handle the case d >= n
		
		if ( arr == null || arr.length == 1 )
			return;
		
		d = d % n;
		
		if ( d == 0 )
			return;
		
		reverse( arr, 0, d-1);
		reverse(arr, d, n-1);
		reverse(arr, 0, n-1);
		
	}
	
	void printArray(int[] arr) {
		
		for ( int i=0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}

}
