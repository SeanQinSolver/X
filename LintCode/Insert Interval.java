/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.isEmpty()) {
            if (newInterval != null) {
                result.add(newInterval);
            }
            return result;
        }
        int position = 0;
        for (Interval interval : intervals) {
            if (newInterval.end < interval.start) {
                result.add(interval);
            } else if (newInterval.start > interval.end) {
                result.add(interval);
                position++;
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
            
        }
        
        result.add(position, newInterval);
        return result;
    }
}
//此题思路分3种情况，插入的start 大于interval的end.将原来的interval放在左边，新的interval直接放右边。 同时position++。
//插入的end小于interval的start。新的interval直接查到左边