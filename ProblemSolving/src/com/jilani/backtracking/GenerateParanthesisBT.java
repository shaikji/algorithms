package com.jilani.backtracking;

import java.util.ArrayList;
import java.util.List;

class GenerateParanthesisBT{

    public static void main(String[] args) {
        
    		int numPairs = 3;

        List<String> results = new ArrayList<String>();
        generateParens(numPairs, numPairs, "", results);    
        printSolution(results);
        
    }

    private static void printSolution(List<String> results) {
    	
    		for ( String result: results) {
    			System.out.println(result);
    		}
		
	}

	static void generateParens( int numLeftParensNeeded, int numRightParensNeeded, String paranStrInProgress, List<String> result) {


        // The goal

        if ( numLeftParensNeeded == 0 && numRightParensNeeded == 0 ){
            result.add(paranStrInProgress);
            return;
        }

        // The choices
        // Can we insert a left paranthesis?

        if ( numLeftParensNeeded > 0   ){
            generateParens(numLeftParensNeeded-1, numRightParensNeeded, paranStrInProgress+"(", result);
        }

        // Can we insert a right paranthesis?
        if ( numLeftParensNeeded < numRightParensNeeded ) {
            generateParens(numLeftParensNeeded, numRightParensNeeded-1, paranStrInProgress+")", result);
        }
    }
    
}