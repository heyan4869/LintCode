// tricky
// use Comparator

package Solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NumberOfPlanesInSky {
	public int countOfAirplanes(List<Interval> airplanes) {
		if (airplanes == null || airplanes.size() == 0) {
			return 0;
		}
		// this round of sort is to make sure landing takes place before flying
		Collections.sort(airplanes, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});
		
		Point[] points = new Point[airplanes.size() * 2];
		for (int i = 0; i < airplanes.size(); i++) {
			points[i * 2] = new Point(airplanes.get(i).start, true);
			points[i * 2 + 1] = new Point(airplanes.get(i).end, false);
		}
		Arrays.sort(points, new Comparator<Point>() {
			public int compare(Point i1, Point i2) {
				return Integer.compare(i1.time, i2.time);
			}
		});
		int res = 0;
		int cur = 0;
		for (Point p : points) {
			if (!p.isStart) {
				cur--;
			} else {
				cur++;
				res = Math.max(res, cur);
			}
		}
		return res;
	}

	class Point {
		int time;
		boolean isStart;

		public Point(int time, boolean isStart) {
			this.time = time;
			this.isStart = isStart;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
