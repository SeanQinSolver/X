public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];
        
        sum[0][0] = grid[0][0];
        
        for (int i = 1; i < M; i++) {
            //注意sum[i][0]与sum[i - 1][0]的关联
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        
        for (int i = 1; i < N; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }
        
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }
        
        return sum[M - 1][N - 1];
    }
}


//写二

public class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        int sum = 0;
        
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        
        sum = 0;
        for (int j = 0; j < n; j++) {
            sum += grid[0][j];
            dp[0][j] = sum;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
