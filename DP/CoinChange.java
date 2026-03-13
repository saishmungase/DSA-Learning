public class CoinChange {

    public static int coinChange(int coin[], int sum){
        int n = coin.length;
        int dp[][] = new int[n+1][sum+1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            int val = coin[i-1];
            for(int j = 1; j <= sum; j++){
                if(val <= j){
                    int inc = dp[i][j-val];
                    int noInc = dp[i-1][j];
                    dp[i][j] = inc + noInc;
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int coin[] = {2, 5, 3, 6};
        int sum = 10;
        System.out.println(coinChange(coin, sum));
    }
}
