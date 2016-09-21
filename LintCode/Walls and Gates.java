public class Solution {
    
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        Queue<Point> queue = new ArrayDeque<Point>();
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                for (int j = 0; j < directions.length; j++) {
                    int x = p.x + directions[j][0];
                    int y = p.y + directions[j][1];
                    if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] == -1) {
                        continue;
                    }
                    if (rooms[x][y] == Integer.MAX_VALUE) {
                        rooms[x][y] = rooms[p.x][p.y] + 1;
                        queue.offer(new Point(x, y));
                    }
                }
            }
        }
    }
    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}