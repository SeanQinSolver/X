class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // 
        for (int i = 0; i < m; i++) {
            dfs(matrix, 0, i, pacific, Integer.MIN_VALUE);
            dfs(matrix, m - 1, i, atlantic, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < n; i++) {
            dfs(matrix, i, 0, pacific, Integer.MIN_VALUE);
            dfs(matrix, i, n - 1, atlantic, Integer.MIN_VALUE);
        }
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }
    
    int[][] direction = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    private void dfs(int[][] matrix, int i, int j, boolean[][] ocean, int height) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || ocean[i][j] || matrix[i][j] < height) {
            return;
        }
        
        ocean[i][j] = true;
        
        for (int m = 0; m < direction.length; m++) {
            dfs(matrix, i + direction[m][0], j + direction[m][1], ocean, matrix[i][j]);
        }  
    }
}