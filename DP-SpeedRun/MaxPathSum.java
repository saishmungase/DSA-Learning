import java.util.*;

public class MaxPathSum {

    static int dp[][];

    public static int path(int[][]grid, int i, int j){

        int n = grid.length;
        int m = grid[0].length;

        if(i < 0 || j < 0 || j >= m) return Integer.MIN_VALUE;

        if(i == n-1) return grid[i][j];

        if(dp[i][j] != -1) return dp[i][j];

        int right = path(grid, i+1, j+1);
        int left = path(grid, i+1, j-1);
        int down = path(grid, i+1, j);

        return dp[i][j] = grid[i][j] + Math.max(down, Math.max(right, left));
    }

    public static void main(String[] args) {
        int grid[][] = {
            {3, 6, 1},
            {2, 3, 4},
            {5, 5, 1}
        };
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            max = Math.max(max, path(grid, 0, i));
        }
        System.out.println(max);
    }
}
