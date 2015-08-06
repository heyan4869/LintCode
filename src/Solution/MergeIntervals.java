// tricky

package Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public static List<Interval> merge(List<Interval> intervals) {
		// use customized comparator
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval obj0, Interval obj1) {
				return obj0.start - obj1.start;
			}
		});

		// merge the intervals
		List<Interval> res = new ArrayList<Interval>();
		Interval prev = null;
		for (Interval inter : intervals) {
			if (prev == null || inter.start > prev.end) {
				res.add(inter);
				prev = inter;
			} else if (inter.end > prev.end) {
				// modify the element already in list
				prev.end = inter.end;
			}
		}
		return res;
	}

	// this can only deal with sorted situation
	public static List<Interval> mergeSorted(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			return res;
		}
		if (intervals.size() == 1) {
			res.add(intervals.get(0));
			return res;
		}
		Interval cur = intervals.get(0);
		for (Interval temp : intervals) {
			if (temp.start > cur.end) {
				res.add(cur);
				cur = temp;
			} else {
				cur.start = Math.min(cur.start, temp.start);
				cur.end = Math.max(cur.end, temp.end);
			}
		}
		if (!res.contains(cur)) {
			res.add(cur);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> intervals = new ArrayList<>();
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
		Interval i3 = new Interval(5, 16);
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);

		List<Interval> result = merge(intervals);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(" -- " + result.get(i).start + " "
					+ result.get(i).end + " -- ");
		}
	}

}
