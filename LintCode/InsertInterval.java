import java.util.*;

public class InsertInterval {
	public static void main(String[] args) {
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(3, 5);
		Interval i3 = new Interval(6, 7);
		Interval i4 = new Interval(8, 10);
		Interval i5 = new Interval(12, 16);

		Interval newInterval = new Interval(4, 8);

		List<Interval> list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		list.add(i5);

		InsertInterval ii = new InsertInterval();
		List<Interval> res = ii.insert(list, newInterval);

		for (Interval i : res) {
			System.out.println(i.start + " " + i.end);
		}
	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (newInterval == null) return intervals;

		int position = 0;
		List<Interval> result = new ArrayList<>();
		for (Interval i : intervals) {
			if (newInterval.end < i.start) {
				result.add(i);
			} else if (newInterval.start > i.end) {
				result.add(i);
				position++;
			} else {
				newInterval.start = Math.min(newInterval.start, i.start);
				newInterval.end = Math.max(newInterval.end, i.end);
			}
		}
		result.add(position, newInterval);
		return result;
	}

	private static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}

// [[1,2],[3,5],[6,7],[8,10],[12,16]]
// newInterval [4, 8] -> [3, 8] -> [3, 8] -> [3, 10]
// [1,2], [3, 10], [12, 16]