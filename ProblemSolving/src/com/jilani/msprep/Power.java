package com.jilani.msprep;

public class Power {

	public static void main(String[] args) {

		
		int x = 3;
		int y = 4;
		
		// Power ( n, p)
		
		//System.out.println(x + " power " + y +" = " + power(x,y) );
		System.out.println(x + " power " + y +" = " + powerNegative(2,-5) );
		System.out.println(x + " power " + y +" = " + powerNegative(2,5) );

	}

	// works only for positive
	static double power ( int n, int p) {
		if ( p < 0)
			return -1;
		
		if ( p == 1 )
			return n;
		
		double power = power ( n, p/2);

		if ( p %2 == 0 ) {
			return power * power;
		} else {
			return n * power * power;
		}
	}
	
	
	static double powerNegative ( float n, int p) {
		
		if ( p == 0 )
			return 1;
		
		double power = powerNegative ( n, p/2);

		if ( p %2 == 0 ) {
			return power * power;
		} else {
			if ( p < 0 )
				return (power * power) / n;
			else 
				return n * power * power;
		}
	}
}
