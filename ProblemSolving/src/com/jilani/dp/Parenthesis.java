package com.jilani.dp;
class Parenthesis{

    public static void main(String[] args) {
        
        char[] symbols = "TTFT".toCharArray();
        char[] operators = "|&^".toCharArray();

        int n = symbols.length;

        System.out.println(" count expression true values = " + countPaths(symbols, operators, n));
    }

    static int countPaths(char[] symbols, char[] operators, int n){


        int[][] T = new int[n][n];
        int[][] F = new int[n][n];

        // Base cases;

        for ( int i=0; i < n; i++){
            T[i][i] = (symbols[i] == 'T') ? 1: 0;
            F[i][i] = (symbols[i] == 'F') ? 1: 0;
        }


        // Start filling values T[i][i+1] 

        for ( int gap = 1; gap < n; gap++){

            for ( int i=0, j = gap; j < n; i++, j++){

                T[i][j] = F[i][j] = 0;

                for ( int k=i; k < j; k++){

                    int tik = T[i][k] + F[i][k];
                    int tkj = T[k+1][j] + F[k+1][j];

                    if ( operators[k] == '&') {
                        T[i][j] += T[i][k] * T[k+1][j];
                        F[i][j] += ( tik * tkj - T[i][k] * T[k+1][j] );

                    } else if ( operators[k] == '|') {
                        T[i][j] += ( tik * tkj - F[i][k] * F[k+1][j] );
                        F[i][j] += (F[i][k] * F[k+1][j]);
                    } if ( operators[k] == '^') {
                        T[i][j] += (T[i][k] * F[k+1][j] + T[k+1][j] * F[i][k]);
                        F[i][j] += (T[i][k] * T[k+1][j] + F[k+1][j] * F[i][k]);
                    }
                }
            }
        }

        return T[0][n-1];
    }
}