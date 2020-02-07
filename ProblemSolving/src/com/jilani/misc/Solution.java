package com.jilani.misc;
class Solution {
    static public boolean isStrobogrammatic(String num) {
        
        if ( null == num){
            return false;
        }
        
        if ( num.length() == 1 ){
            if ( num == "1" || num =="8"){
                return true;
            } else {
                return false;
            }
        }
        
        char[] arr = num.toCharArray();
        
        int i = 0;
        int j = num.length()-1;
        
        while ( i <= j ) {
            
            if ( arr[i] == '1' && arr[j] == '1'  || arr[i] == '8' && arr[j] == '8' 
                || arr[i] == '6' && arr[j] == '9' || arr[i] == '9' && arr[j] == '6') {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;

    }
    
    public static void main ( String args[]) {
    	System.out.println(" result = " + isStrobogrammatic("1"));
    }
}