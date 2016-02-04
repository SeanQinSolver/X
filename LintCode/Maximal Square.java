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