package com.jilani.algos.dnc;

public class Power {

	public static void main(String[] args) {

		int x = 2; int y=-3;
		
		System.out.println(" Power(" + x+","+y+") = " + power(x,y) );
	}
	
	static double power(int x, int y) {
		
		if ( x == 1 )
			return 1;
		
		if ( y == 0 )
			return 1;
		
		if ( y == 1)
			return x;
		
		double res = power(x, y/2);
		
		if ( y %2 == 0 )
			return res * res;
		else {
			
			if ( y > 0 )
				return x * res * res;
			else
				return (res * res) / x;
		}
	}

}
