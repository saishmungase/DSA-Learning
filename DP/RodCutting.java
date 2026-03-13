public class RodCutting {

    public static int maxRodCut(int rodLen, int len[], int prices[]){
        int n = len.length;
        int dp[][] = new int[n+1][rodLen+1];

        for(int i = 1; i <= n; i++){
            int l = len[i-1];
            int price = prices[i-1];
            for(int j = 1; j <= rodLen; j++){
                if(l <= j){
                    int inc = price + dp[i][j-l];
                    int noInc = dp[i-1][j];

                    dp[i][j] = Math.max(inc, noInc);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][rodLen];
    }

    public static void main(String[] args) {
        int len[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLen = 8;

        System.out.println(maxRodCut(rodLen, len, price));
    }
}
