package com.jilani.arrays;

public class RearrangePositiveNNegativeStable {

	public static void main(String[] args) {

		//int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
		int[] arr = { -1, -2, 3, 4, 5, 6, 7, 8, 9 };
		int n = arr.length;

		printArray(arr, n);
		rearrange(arr, arr.length);

		printArray(arr, n);
	}

	// Stable arrangement:
	static void rearrange(int[] arr, int n) {

		int outofplace = -1;

		for (int i = 0; i < n; i++) {
			
		
			if ( outofplace >= 0 ) {
				
				if ( arr[outofplace] < 0 && arr[i] >= 0 || arr[outofplace] >= 0 && arr[i] < 0 )
				{
					rotateArray(arr, n, outofplace, i);
					if ( i - outofplace >= 2)
						outofplace += 2;
					else
						outofplace = -1;
				}
				
			} else {
				
				if ( arr[i] < 0 && i %2 == 1 || arr[i] >= 0 && i %2 == 0 )
					outofplace = i;
			}
			
			
		}

	}
	
	static void rotateArray(int[] arr, int n, int start, int end) {
		
		int temp = arr[end];
		
		for ( int i= end; i > start; i--)
			arr[i] = arr[i-1];
		
		arr[start] = temp;
	}

	static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + "   ");
		System.out.println();
	}

}
