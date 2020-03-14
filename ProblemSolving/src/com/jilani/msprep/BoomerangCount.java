package com.jilani.msprep;

import java.util.HashMap;

public class BoomerangCount {

	public static void main(String[] args) {
		
		int[][] points = {{0,0}, {1,0},{2,0}};
		System.out.println(" Boomerang count =  " + countBoomerangs(points));

	}
	
	static int countBoomerangs( int[][] points) {
		int n = points.length;
		int res = 0;
		
		HashMap<Integer, Integer> map = new HashMap();
		for ( int i=0; i < n; i++) {
			// Start from a single point and find the distance of all other points
			
			for ( int j=0; j < n; j++) {
				if ( i == j) // Distance from same point
					continue;
				
				int d = getDistance ( points[i], points[j]);
				map.put(d, map.getOrDefault(d,0)+1);
			}
			
			// Process the count now
			for ( int value: map.values()) {
				res+= value * (value-1);
			}
			map.clear();
		
		}
		
		return res;
	}
	
	static int getDistance( int[] a, int[] b) {
		int dy = b[1] - a[1];
		int dx=  b[0] - a[0] ;
		
		return  dy*dy + dx* dx;
	}

}
