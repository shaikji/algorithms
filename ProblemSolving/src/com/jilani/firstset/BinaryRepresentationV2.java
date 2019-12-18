package com.jilani.firstset;
class BinaryRepresentationV2{

    public static void main(String[] args) {
        int num = 16;
        printBinary(num);
        printBinaryRecursion(num);
    }

    static void printBinary ( int n ) {

        StringBuffer sbr = new StringBuffer();
        
        while ( n > 0 ) {
        		sbr.append(n%2);
        		n = n/2;
        }
        
        System.out.println(sbr.reverse());
    }
    
    
    static void printBinaryRecursion(int n ) {
    		
    		if ( n > 0 ) {
    			printBinaryRecursion(n/2);
    			System.out.print(n%2);
    		}
    }
    
}

