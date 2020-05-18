package com.jilani.arrays;

public class RotateArrayBlockSwapping {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int n = arr.length;
		int d = 2;

		RotateArrayBlockSwapping rotate = new RotateArrayBlockSwapping();

		System.out.println(" Original array ");
		rotate.printArray(arr);
		System.out.println();
		n = arr.length;
		d = 2;
		System.out.println(" N = " + n + " d = " + d);
		rotate.rotate(arr, n, d);
		System.out.println(" After rotation ");
		rotate.printArray(arr);
		System.out.println("\n\n");
	}

	void rotate(int[] arr, int n, int d) {

		// to handle the case d >= n
		d = d % n;
		
		// rotate arr from i = 0, size = n, 'd' elements
		rotate(arr, 0, d, n );

	}
	
	
	void rotate ( int[] arr, int i, int d, int n ) {
		
		
		if ( d == 0 || d == n)
			return;
		
		
		if ( d == n-d) {
			swap( arr, i, i + d, d);
			return;
		} 
		
		if ( d < n-d ) {
			swap( arr, i, i + n-d, d);
			rotate(arr, i, d, n - d);
		} else {
			swap (arr, i, d, n-d);
			rotate( arr, i + n-d, 2 * d - n, d);
		}
		
	}
	
	// Block swap 'd' elements, starting index fi, starting index si, block size 'd'
	void swap( int[] arr, int fi, int si, int d ) {
		
		int temp;
		
		for ( int i=0; i < d; i++) {
			temp = arr[fi+ i];
			arr[fi + i] = arr[si+i];
			arr[si+i] = temp;
		}
	}

	void printArray(int[] arr) {

		for (int i = 0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}

}
