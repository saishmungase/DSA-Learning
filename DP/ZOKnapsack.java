package DP;

import java.util.Arrays;

public class ZOKnapsack {

    static int dp[][];
    static int count = 0;

    public static int ksMem(int weight[], int val[], int wt, int idx){

        if(idx < 0) return 0;
        if(dp[idx][wt] != -1) return dp[idx][wt];
        count++;

        if(weight[idx] <= wt){
            int get = val[idx] + ksMem(weight, val, wt - weight[idx], idx-1);

            int skip = ksMem(weight, val, wt, idx-1);

            return dp [idx][wt] = Math.max(get, skip);
        }
        return dp[idx][wt] = ksMem(weight, val, wt, idx-1);
    }

    public static int ksRec(int weight[], int val[], int wt, int idx){

        if(idx < 0) return 0;

        count++;

        if(weight[idx] <= wt){
            int get = val[idx] + ksRec(weight, val, wt - weight[idx], idx-1);

            int skip = ksRec(weight, val, wt, idx-1);

            return Math.max(get, skip);
        }
        return ksRec(weight, val, wt, idx-1);
    }

    public static int ksTab(int weight[], int val[], int wt){
        int n = weight.length;
        int dp[][] = new int[n+1][wt + 1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }

        for(int j = 0; j <= wt; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= wt; j++){
                int v = val[i-1];
                int w = weight[i-1];
                if(w <= j){
                    int inc = v + dp[i-1][j-w];
                    int noInc = dp[i-1][j];
                    dp[i][j] = Math.max(inc, noInc);
                }
                else{
                    int noInc = dp[i-1][j];
                    dp[i][j] = noInc;
                }
            }
        }

        System.out.println("================ PRINT BOARD =================");
        print(dp);
        System.out.println("==============================================");

        return dp[n][wt];
    }


    public static void print(int dp[][]){
        for(int row[] : dp){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt [] = { 2, 5, 1, 3, 4 };
        // dp = new int[val.length+1][8];
        // for(int row[] : dp){
        //     Arrays.fill(row, -1);
        // }
        // System.out.println(ksRec(wt, val, 7, val.length-1) + " (" + count + ")");
        // count = 0;
        // System.out.println(ksMem(wt, val, 7, val.length-1) + " (" + count + ")");
        System.out.println(ksTab(wt, val, 7));
    }
}
