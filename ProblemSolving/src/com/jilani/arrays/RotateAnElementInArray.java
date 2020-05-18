package com.jilani.arrays;

public class RotateAnElementInArray {

	public static void main(String[] args) {

		
		int[] arr = {1, 2, 3, 4, 5, 6, 7,8};
		int n = arr.length;
		int d = 2;
		
		RotateAnElementInArray rotate = new RotateAnElementInArray();
		
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
	
	void rotate( int[] arr, int n, int d) {
		
		// to handle the case d >= n
		d = d % n;
		
		int gcd = gcd(n,d);
		
		for ( int i=0; i < gcd; i++) {
			
			int j = i;
			int k;
			
			int temp = arr[i];
			while ( true ) {
				
				k = j + d;
				
				if ( k >= n)
					k = k - n;
				
				if ( k == i)
					break;
				
				arr[j] = arr[k];
				j = k;
			}

			arr[j] = temp; 
		}
		
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
