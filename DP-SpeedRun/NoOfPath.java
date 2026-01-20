/*
If You go from 0,0 to m-1, n-1
is equivalent as
going from m, n to 1, 1
*/

import java.util.*;

public class NoOfPath {

    static int[][] dp;

    static int dpCount = 0;
    static int count = 0;
    
    public static int dpWays(int m, int n){

        if(m == 1 && n == 1) return 1;
        if(m < 0 || n < 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        dpCount++;
        int dWay = dpWays(m-1, n);
        int rWay = dpWays(m, n-1);

        return dp[m][n] = dWay + rWay;
    }

    public static int ways(int m, int n){

        if(m == 1 && n == 1) return 1;
        if(m < 0 || n < 0) return 0;
        count++;
        int dWay = ways(m-1, n);
        int rWay = ways(m, n-1);

        return dWay + rWay;
    }

    public static void main(String[] args) {
        int m = 11;
        int n = 9;

        dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println( "Dp Way:- " + dpWays(m, n) + " ( Iterations:- " + dpCount + " )");
        
        System.out.println( "Non Dp Way:- " + ways(m, n) + " ( Iterations:- " + count + " )");
    }
}