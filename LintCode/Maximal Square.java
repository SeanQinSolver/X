public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        if (n == 0) {
            return ans;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return ans;
        }
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            res[i][0] = matrix[i][0];
            ans = Math.max(res[i][0], ans);
            for (int j = 1; j < m; j++) {
                if (i > 0) {
                    if (matrix[i][j] > 0) {
                        res[i][j] = Math.min(res[i-1][j], Math.min(res[i][j-1], res[i-1][j-1])) + 1;
                    } else {
                        res[i][j] = 0;  
                    }
                } else {
                    res[0][j] = matrix[0][j];
                }
                ans = Math.max(res[i][j], ans);
            }
        } 
        return ans * ans;
    }
}

//写法二

public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        
        int[][] result = new int[matrix.length][matrix[0].length];
        int ans = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            result[i][0] = matrix[i][0];
            ans = Math.max(ans, result[i][0]);
            for (int j = 1; j < matrix[0].length; j++) {
                if (i > 0) {
                    if (matrix[i][j] > 0) {
                        result[i][j] = Math.min(result[i - 1][j], Math.min(result[i - 1][j - 1], result[i][j - 1])) + 1;
                    } else {
                        result[i][j] = 0;
                    }
                } else if (i == 0) {
                    result[0][j] = matrix[0][j];
                }
                ans = Math.max(ans, result[i][j]);
            }
        }
        return ans * ans;
    }
}

//此题注意dp的题在两层循环的时候第一层是所有0-matrix.length的row。第
//二层是1-matrix[0].length的col


//METHOD3 DP with intialize at the begining， note this is char[][]

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        int side = 0;
        
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            side = Math.max(side, dp[i][0]);
        }
        
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            side = Math.max(side, dp[0][i]);
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != '0') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                } else {
                    dp[i][j] = 0;
                }
                side = Math.max(side, dp[i][j]);
            }
        }
        return side * side;
    }
}


//令状态dp[i][j]表示为从左上角(不一定是(0,0))到矩阵中坐标(i,j)为止能构成正方形的最大边长。
