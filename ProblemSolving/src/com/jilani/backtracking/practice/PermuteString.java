package com.jilani.backtracking.practice;

import java.util.ArrayList;
import java.util.List;

class PermuteString{

    static void permute(String str, int l, int r,List<String> results){

        if ( l == r  ) {
            results.add(str);
            return;
        }

        for ( int i=l; i <= r; i++) {
            str = swap(str, l, i);
            // set the lth position with l to r 
            permute(str, l+1, r, results);
            // unset for the next calls
            str = swap(str, l, i);
        }
    }

    public static void main (String[] args){

        String str = "ABC";
        List<String> results = new ArrayList();
        permute(str, 0, str.length() -1, results);
        
       for ( String s: results) {
    	   		System.out.println(s);
       }
       
       System.out.println(" count = " + results.size());
    }
    
    static String swap(String str, int i, int j) {
    		char[] s = str.toCharArray();
    		char temp = s[i];
    		s[i] = s[j];
    		s[j] = temp;
    		return new String(s);
    }

}

