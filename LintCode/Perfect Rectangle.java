//O(N)
public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }
        
        int sum = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        Map<Point, Integer> map = new HashMap<>();
        
        for (int[] rect : rectangles) {
            Point p1 = new Point(rect[0], rect[1], 1);
            Point p2 = new Point(rect[2], rect[3], 2);
            Point p3 = new Point(rect[2], rect[1], 3);
            Point p4 = new Point(rect[0], rect[3], 4);
            
            sum += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            if (minX > rect[0]) {
                minX = rect[0];
            }
            
            if (minY > rect[1]) {
                minY = rect[1];
            }
            
            if (maxX < rect[2]) {
                maxX = rect[2];
            }
            if (maxY < rect[3]) {
                maxY = rect[3];
            }
            
            Point[] array = {p1, p2, p3, p4};
            for (Point p : array) {
                if (map.containsKey(p) && map.get(p) != p.index) {
                    map.remove(p);
                } else {
                    map.put(p, p.index);
                }
            }
        }
        return map.size() == 4 && sum == (maxX - minX) * (maxY - minY);
    }
    
    static class Point {
        int x;
        int y;
        int index;
        Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point tmp = (Point) o;
                return this.x == tmp.x && this.y == tmp.y;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return new Integer(x).hashCode() + new Integer(y).hashCode();
        }
    }
}