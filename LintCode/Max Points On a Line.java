/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0)  return 0;
        
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int max = 1;
        
        for (int i = 0; i < points.length; i++) {
            map.clear();
            //注意此点需要先加入一个value。如果是[0,0] [0,0]的话那么map为空，下面的for(int temp : map.values)就进不去
            map.put((double)Integer.MAX_VALUE, 1);
            int count = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    count++;
                    continue;
                }
                
                double key = points[i].x - points[j].x == 0 ? Integer.MAX_VALUE : (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
                //注意此点可能会有-0.0要变成0.0
                if (key == -0.0) {
                    key = Math.abs(key);
                }
                //key = Math.abs(key);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 2);
                }
            }
            for (int temp : map.values()) {
                max = Math.max(temp + count, max);
            }
        }
        return max;
    }
}

//此题就是用hashmap存储斜率，斜率相同的累加。另注意重复的点累加起来dup。