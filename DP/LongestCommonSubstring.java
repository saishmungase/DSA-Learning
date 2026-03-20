public class LongestCommonSubstring {

    public static int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        int longest = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    longest = Math.max(longest, dp[i][j]);
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        System.out.println(lcs(s1, s2));
    }
}