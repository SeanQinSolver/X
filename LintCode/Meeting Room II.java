/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        };
        
        Arrays.sort(intervals, comp);
        PriorityQueue<Room> heap = new PriorityQueue<Room>();
        
        
        for (Interval i : intervals) {
            if (heap.isEmpty() || i.start < heap.peek().getEnd()) {
                heap.offer(new Room(i));
            } else {
                Room temp = heap.poll();
                temp.intervals.add(i);
                heap.offer(temp);
            }
        }
        return heap.size();
    }
}
class Room implements Comparable<Room>{
    List<Interval> intervals;
    public Room(Interval interval) {
        intervals = new ArrayList<>();
        intervals.add(interval);
    }
    public int getEnd() {
        return intervals.get(intervals.size() - 1).end;
    }
    @Override
    public int compareTo(Room other) {
        return this.getEnd() - other.getEnd();
    }
    
}