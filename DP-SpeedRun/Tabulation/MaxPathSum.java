

public class MaxPathSum {

    public static int maxSum(int arr[][]){
        int n = arr.length;
        int m = arr[0].length;

        int dp[][] = new int[n][m];
        for(int i = 0; i < m ; i++){
            dp[0][i] = arr[0][i];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                int left = (j-1>0) ? dp[i-1][j-1] : 0;
                int right = (j+1<n) ? dp[i-1][j+1] : 0;
                int up = dp[i-1][j];
                dp[i][j] = arr[i][j] + Math.max(left, Math.max(up, right));
            }
        }
        int max = -1;
        for(int i = 0; i < m; i++){
            max = Math.max(dp[n-1][i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[][] = {
            {3, 6, 1},
            {2, 3, 4},
            {5, 5, 1}
        };
        System.out.println(maxSum(arr));
    }
}
