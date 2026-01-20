import java.util.*;

public class SticklerTheif {
    public static void main(String[] args) {
        int arr[] = { 6, 5, 1, 7, 4 };
        int n = arr.length;
        int dp[] = new int[n];

        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], arr[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max((arr[i] + dp[i-2]), dp[i-1]);
        }
        System.out.println(Math.max(dp[n-1], dp[n-2]));
    }
}
