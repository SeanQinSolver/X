/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Point {
    int time;
    int flag;
    public Point(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }
}
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        Comparator<Point> cmp = new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                //时间相同的话，landing happen first。所以p1.time = 1, p2.time = 0的话，p2排在p1之前.0为landing
                if (p1.time == p2.time) return p1.flag - p2.flag;
                else return p1.time - p2.time;
            }
        };
        
        List<Point> list = new ArrayList<Point>();
        
        for (Interval i :  airplanes) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }
        
        Collections.sort(list, cmp);
        int count = 0, max = Integer.MIN_VALUE;
        for (Point p : list) {
            if (p.flag == 1) count++;
            if (p.flag == 0) count--;
            max = Math.max(max, count);
        }
        return max;
    }
}