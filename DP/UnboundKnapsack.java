// We can use a value multiple times

public class UnboundKnapsack {

    public static int unBounded(int val[], int wt[], int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= W; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                int v = val[i-1];
                int weight = wt[i-1];
                if(weight <= j){
                    int keep = v + dp[i][j-weight];
                    int notKeep = dp[i-1][j];
                    dp[i][j] = Math.max(keep, notKeep);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(unBounded(val, wt, W));
    }
}
