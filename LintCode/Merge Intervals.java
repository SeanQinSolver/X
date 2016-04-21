/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return list;
        }
        
        Collections.sort(intervals ,comp);
        Interval point = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval curt = intervals.get(i);
            if (curt.start <= point.end) {
                point.end = Math.max(point.end, curt.end);
            } else {
                list.add(point);
                point = curt;
            }
        }
        //注意循环外的add非常重要
        list.add(point);
        return list;
    }
    
    private Comparator<Interval> comp = new Comparator<Interval>(){
    public int compare(Interval i1, Interval i2) {
    return i1.start - i2.start;
}
};
}


//注意循环外的add非常重要