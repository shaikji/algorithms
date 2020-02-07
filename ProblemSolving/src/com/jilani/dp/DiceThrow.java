package com.jilani.dp;
class DiceThrow{
    

    public static void main(String[] args) {
        int numDice =2; // dice
        int faces = 4;
        int sum = 1;

        System.out.println(" ways of getting sum " + sum + " = " + findWaysRec(faces, numDice, sum));
        System.out.println(" ways of getting sum " + sum + " = " + findWaysRec(2, 2, 3));
        System.out.println(" ways of getting sum " + sum + " = " + findWaysRec(6, 3, 8));
        System.out.println(" ways of getting sum " + sum + " = " + findWaysRec(4, 2, 5));
        System.out.println(" ways of getting sum " + sum + " = " + findWaysRec(4, 3, 5));

        System.out.println(" ways of getting sum " + sum + " = " + findWaysDP(faces, numDice, sum));
        System.out.println(" ways of getting sum " + sum + " = " + findWaysDP(2, 2, 3));
        System.out.println(" ways of getting sum " + sum + " = " + findWaysDP(6, 3, 8));
        System.out.println(" ways of getting sum " + sum + " = " + findWaysDP(4, 2, 5));
        System.out.println(" ways of getting sum " + sum + " = " + findWaysDP(4, 3, 5));


    }

    static int findWaysRec(int m, int n, int X){

        if ( X <= 0 ){
            return 0;
        }

        if ( n == 1 ){
            return X <= m? 1: 0;
        }


        int ways = 0;

        for ( int i=1; i <= m; i++){
            ways += findWaysRec(m, n-1, X-i);
        }

        return ways;
    }

    static int findWaysDP(int m, int n, int X) {

        int[][] table = new int[n+1][X+1];
        
        for ( int i=1; i <= X && i <=m; i++){
            table[1][i] = 1;
        }

        for ( int i=2; i <= n; i++){
            for ( int j=1; j <= X; j++){

                // Solve the problem

                for ( int k=1; k <=m && k < j ; k++) {

                    table[i][j] += table[i-1][j-k];
                }
            }
        }
        return table[n][X];
    }
}