package com.jilani.dailycodingproblems;

class DailyCodingProblem65 {

    public static void main(String[] args) {
        
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };

        printSpiral(matrix, matrix.length, matrix[0].length);
    }

    static void printSpiral( int[][] matrix, int m, int n){

        // print from row to column

        int row_start =0;
        int row_end = m;
        int col_start = 0;
        int col_end = n; 

        while ( row_start < row_end && col_start < col_end){

            for ( int i= col_start; i < col_end; i++){
                System.out.println(matrix[row_start][i]);
            }
            row_start++;
    
            for ( int i=row_start; i < row_end; i++){
                System.out.println(matrix[i][col_end-1]);
            }
    
            col_end--;
    
            if( row_start < row_end){
                for ( int i=col_end-1; i >= col_start; i--){
                    System.out.println(matrix[row_end-1][i]);
                }
        
                row_end--;
            }
    
            if ( col_start < col_end){
                for ( int i=row_end-1; i >= row_start; i--){
                    System.out.println(matrix[i][col_start]);
                }
                col_start++;
            }
        }

    }

}