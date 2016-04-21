// Divide N Conquer
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    private int n;
    private int[][] minSum;
    private int[][] triangle;
    public int search(int x, int y) {
        //下标越界
        if (x >= n) {
            return 0;
        }
        //记忆化
        //复杂度由之前的O(2n)变为O(n2)因为每个元素只计算一次。所以：1 + 2 + 。。。。 + n = o(n2)
        if (minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }
        //把最小值先放在minSum里
        minSum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1)) + triangle[x][y];
        return minSum[x][y];
    }
    
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        
        this.n = triangle.length;
        this.triangle = triangle;
        this.minSum = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }
        return search(0, 0);
    }
}

//dp

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    
    
    
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0) {
            return -1;
        }
        //get the row number
        int len = triangle.length;
        int[][] dp = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            dp[len - 1][i] = triangle[len - 1][i];
        }
        //从倒数第二行开始
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }
}

