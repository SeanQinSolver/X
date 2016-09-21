//method1
//dfs
//method1
//dfs
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int result = 0;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check(matrix, i, j)) {
                    cache[i][j] = Math.max(cache[i][j], 1);
                    result = Math.max(result, dfs(matrix, i, j, 1, cache));
                }
            }
        }
        
        return result;
    }
    
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    private int dfs(int[][] matrix, int i, int j, int len, int[][] cache) {
        if (cache[i][j] > len) {
            return -1;
        }
        int ways = len;
        for (int m = 0; m < directions.length; m++) {
            int newX = i + directions[m][0];
            int newY = j + directions[m][1];
            if (newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[0].length) {
                continue;
            }
            if (matrix[newX][newY] > matrix[i][j]) {
                ways = Math.max(ways, dfs(matrix, newX, newY, len + 1, cache));
                cache[newX][newY] = len + 1;
            }
        }
        return ways;
    }
    
    
    private boolean check(int[][] matrix, int i, int j) {
        for (int n = 0; n < directions.length; n++) {
            int newX =  i + directions[n][0];
            int newY =  j + directions[n][1];
            if (newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[0].length) {
                continue;
            }
            if (matrix[newX][newY] < matrix[i][j]) {
                return false;
            }
        }
        return true;
    }
}