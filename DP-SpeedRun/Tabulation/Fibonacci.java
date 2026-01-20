/*

DP without recurssion is Tabulation

Tabulation => Bottom up approach
DP => To to Bottom approach

*/

public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;
        int dp[] = new int[n+1];
        if(n>0) dp[1] = 1;
        for(int i = 2; i <=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
