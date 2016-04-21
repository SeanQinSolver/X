public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                //物品的值大于可承受的j
                if (j < A[i])  {
                    dp[i + 1][j] = dp[i][j];
                } else {
                    //dp[i][j]为不选A[i]的方案，dp[i][j - A[i]] + A[i]为选A[i]的方案
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - A[i]] + A[i]);
                }
            }
        }
        return dp[n][m];
    }
}

//dp有状态转移方程
//dp[i + 1][j]为前i个物品中选出重量不超过j的最大值

//写法2


public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (A[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + A[i - 1]);
                }
            }
        }
        return dp[n][m];
    }
}

//dp有状态转移方程
//dp[i + 1][j]为前i个物品中选出重量不超过j的最大值