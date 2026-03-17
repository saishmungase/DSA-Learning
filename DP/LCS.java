// Longest Common Subsequence

public class LCS {

    static int dp[][];
    static int c = 0;


    public static int lcsRec(String str1, String str2, int n, int m){
        if(n < 0 || m < 0) return 0;

        if(dp[n][m] != 0) return dp[n][m];
        c++;
        if(str1.charAt(n) == str2.charAt(m)){
            return dp[n][m] = (1 + lcsRec(str1, str2, n-1, m-1));
        }
        return dp[n][m] = Math.max(lcsRec(str1, str2, n-1, m), lcsRec(str1, str2, n, m-1));
    }

    public static int lcsTab(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int tabDp[][] = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    tabDp[i][j] = 1 + tabDp[i-1][j-1];
                }
                else{
                    tabDp[i][j] = Math.max(tabDp[i][j-1], tabDp[i-1][j]);
                }
            }
        }

        return tabDp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        String str3 = "abcdge";
        String str4 = "abedg";

        dp = new int[str2.length()][str4.length()];
        
        System.out.println(lcsRec(str2, str4, str2.length()-1, str4.length()-1));
        System.out.println(lcsTab(str2, str4 ));
        System.out.println(c);
    }
}
