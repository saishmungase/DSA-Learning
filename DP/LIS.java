import java.util.TreeSet;

public class LIS {

    public static int lis(int a[], int sa[]){
        int n = a.length;
        int m = sa.length;
        int dp[][] = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(a[i-1] == sa[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int arr[] = { 50, 3, 1, 56, 1, 4, 8};
        TreeSet<Integer> ts = new TreeSet<>();
        for(int val : arr){
            ts.add(val);
        }
        int sortedArr[] = new int[ts.size()];
        int j = 0;
        for(int uniqueVal : ts){
            sortedArr[j++] = uniqueVal;
        }
        System.out.println(lis(arr, sortedArr));
    }
}
