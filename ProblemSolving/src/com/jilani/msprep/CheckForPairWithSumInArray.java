package com.jilani.msprep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckForPairWithSumInArray {

	public static void main(String[] args) {
		
		int[] arr = {1, 4, 45, 6, 10, -8} ;
		int sum = 16;
		
		System.out.println(" sum exists = " + sumExists(arr, sum) );
		System.out.println(" sum exists = " + sumExistsV2(arr, sum) );

	}
	
	static boolean sumExists (int[] arr, int sum) {
		
		if ( arr == null || arr.length == 0 )
			return false;
		
		Set<Integer> set = new HashSet();
		
		for ( int i=0; i < arr.length; i++)
		{
			if ( set.contains(sum - arr[i]))
				return true;
			else {
				set.add(arr[i]);
			}
		}
		
		return false;
	}
	
	static boolean sumExistsV2 (int[] arr, int sum) {
		
		if ( arr == null || arr.length == 0 )
			return false;
		
		Arrays.sort(arr);
		
		int i = 0;
		int j = arr.length-1;
		
		while( i < j ) {
			
			if ( arr[i] + arr[j] == sum ) {
				return true;
			} else if ( arr[i] +arr[j] < sum ) {
				i++;
			} else {
				j--;
			}
			
		}
		
		return false;
	}

}
