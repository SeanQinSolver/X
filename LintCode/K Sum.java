//method1 http://www.cnblogs.com/yuzhangcmu/p/4279676.html
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        int len = A.length;
        
        int[][][] dp = new int[len + 1][k + 1][target + 1];
        //将前i个字母选出0个字母的sum是0的选择有多少种：1
        for (int i = 0; i <= len; i++) {
            dp[i][0][0] = 1;
        }
        
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                for (int m = 1; m <= target; m++) {
                    dp[i][j][m] = dp[i - 1][j][m];
                    if (m >= A[i - 1]) {
                        dp[i][j][m] += dp[i - 1][j - 1][m - A[i - 1]];
                    }
                }
            }
        }
        return dp[len][k][target];
    }
}

//method1 optimization

