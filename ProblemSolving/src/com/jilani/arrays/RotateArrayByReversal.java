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
		d = d % n;
		
		
		reverse( arr, 0, d-1);
		reverse(arr, d, n-1);
		reverse(arr, 0, n-1);
		
	}
	
	int gcd (int a, int b) {
		
		if ( b == 0 )
			return a;
		
		return gcd(b, a % b);
		
	}
	
	void printArray(int[] arr) {
		
		for ( int i=0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}

}
