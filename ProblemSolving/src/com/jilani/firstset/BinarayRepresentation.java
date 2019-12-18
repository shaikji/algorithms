package com.jilani.firstset;

class BinaryRepresentation{

    public static void main(String[] args) {
        int num = 1;
        printBinary(num);
    }

    static void printBinary ( int num ) {
        if ( num < 0 )
            return;
        
        // check every bit and print its status

        for ( int i = 31; i >=0; i--){
            if ( ((1 << i ) & num) == 0 ){
                System.out.print("0");
            } else {
                System.out.print("1");
            }
        }
        System.out.println("");
    }
    
}