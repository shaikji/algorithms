package com.jilani.searching;

// Median of two sorted arrays of same size
// https://www.geeksforgeeks.org/median-of-two-sorted-arrays/

public class Searching_03 {

    
    /* Driver program to test above function */
    public static void main (String[] args) 
    { 
        int ar1[] = {1, 12, 15, 26, 38}; 
        int ar2[] = {2, 13, 17, 30, 45}; 
       
        int n1 = ar1.length; 
        int n2 = ar2.length; 
        if (n1 == n2) 
            System.out.println("Median is " + 
                        getMedian(ar1, ar2, n1)); 
        else
            System.out.println("arrays are of unequal size"); 
    }

	private static double getMedian(int[] arr1, int[] arr2, int n) {
		
		if ( arr1 == null || arr2 == null || n <= 0 ) {
			return -1;
		}
		return getMedian(arr1, arr2, 0, n-1, 0 , n-1);
	}

	private static double getMedian(int[] arr1, int[] arr2, int start_a, int end_a, int start_b, int end_b) {
		
		int idxDiffA = end_a - start_a;
		int idxDiffB = end_b - start_b;
		
		int n1 = end_a - start_a +1 ;
		int n2 = end_b - start_b +1;
		
		if (idxDiffA == 0 && idxDiffB == 0  ) // Only one element in each array
		{
			return (arr1[start_a]+ arr2[start_b])/2;
		}
		
		if ( idxDiffA == 1 && idxDiffB == 1 ) { // Two elements in each array
			
			int max = Math.max(arr1[start_a], arr2[start_b]);
			int min = Math.min(arr1[end_a], arr2[end_b]);
			
			return ( max + min )/2;
		}
		
		int m1_index = start_a + n1/2;
		int m2_index = start_b+ n2/2;
				
				
		
		
		int m1 = findMedian( arr1, n1);;
		int m2 = findMedian( arr2, n2);
		
		if ( m1 == m2 ) {
			return m1;
		}
		
		if ( m1 < m2) {
			start_a = m1_index;
			end_b = m2_index;
		}  else {
			end_a = m1_index;
			start_b = m2_index;
		}
		
		return getMedian(arr1, arr2, start_a, end_a, start_b, end_b);
		
	}

	private static int findMedian(int[] arr,int n) {
		
		if ( n %2 == 0 ) {
			return (arr[n/2] + arr[n/2-1])/2;
		} else {
			return arr[n/2];
		}
	}  

	

}



