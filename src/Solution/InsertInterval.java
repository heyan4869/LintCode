// tricky

package Solution;

import java.util.ArrayList;

public class InsertInterval {
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		for (Interval i : intervals) {
			if (newInterval == null || i.end < newInterval.start)
				result.add(i);
			else if (i.start > newInterval.end) {
				result.add(newInterval);
				result.add(i);
				newInterval = null;
			} else {
				newInterval.start = Math.min(newInterval.start, i.start);
				newInterval.end = Math.max(newInterval.end, i.end);
			}
		}
		if (newInterval != null)
			result.add(newInterval);
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		Interval i1 = new Interval(3, 5);
		// Interval i2 = new Interval(6, 9);
		intervals.add(i1);
		// intervals.add(i2);
		Interval newInterval = new Interval(1, 2);
		ArrayList<Interval> result = insert(intervals, newInterval);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(" -- " + result.get(i).start + " "
					+ result.get(i).end + " -- ");
		}
	}

}
