package com.jilani.arrays;

public class ExecuteCommands {

	int[] arr;
	int size;
	int[] prefixsum;
	int rotationidx;
	
	
	ExecuteCommands(int[] arr, int n) {
		
		this.arr = new int[n];
		for ( int i=0; i < n; i++)
			this.arr[i] = arr[i];
		
		prefixsum = new int[n+1];
		rotationidx = 0;
		size = n;
		
		prefixsum[0] = 0;
		
		for ( int i=1; i < n+1; i++) {
			prefixsum[i] = prefixsum[i-1] + arr[i-1];
		}
		System.out.println();
	}
	
	
	int query(int query_type, int start, int end) {
		
		int l = (start + rotationidx)% size;
		
		int r = (end + rotationidx) % size;
		
		int sum = 0;
		
		
		if ( l <= r ) 
			sum = prefixsum[r+1]- prefixsum[l];
		else 
			sum = prefixsum[size] + prefixsum[r+1] - prefixsum[l];
		
		return sum;	
	}
	
	void query( int query_type, int x) {
		
		switch ( query_type) {
		
		case 1: 
			rightShift(x);
			break;
		case 2: 
			leftShift(x);
			break;
		}
	}
	
	void rightShift(int x) {
		rotationidx = (size + rotationidx - x) % size;
	}
	
	void leftShift(int y) {
		rotationidx = (rotationidx + y)  %size;
	}
	
	public static void main(String[] args) {

		int[] input = { 1, 2, 3, 4, 5 };
		
		ExecuteCommands commands = new ExecuteCommands(input, input.length);
		
		printArray(input);
		System.out.println(" sum = " + commands.query(3,0,1));
		commands.query(1, 2);
		System.out.println(" sum = " + commands.query(3,0,1));
		commands.query(2, 2);
		System.out.println(" sum = " + commands.query(3,0,1));

		/*
		 * System.out.println(" sum = " + commands.query(3,2,3));
		 * System.out.println(" sum = " + commands.query(3,4,5));
		 * System.out.println(" sum = " + commands.query(3,4,6));
		 */
		
	}

	static void printArray(int[] arr) {
		
		for ( int i=0; i < arr.length; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}
	
}
