public class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    private int n, m;
    public int numIslands(boolean[][] grid) {
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == true) {
                    removeIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    //once find the true(1) point change to false, move to adjacent true point then change to false;
    private void removeIsland(boolean[][] grid, int x, int y) {
        grid[x][y] = false;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (grid[nextX][nextY] == true) {
                    removeIsland(grid, nextX, nextY);
                }
            }
        }
    }
}