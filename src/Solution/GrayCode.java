package Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GrayCode {
	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Set<Integer> hs = new HashSet<Integer>();
		res.add(0);
		hs.add(0);
		assist(0, n, res, hs);
		return res;
	}

	private static void assist(int pre, int n, ArrayList<Integer> res,
			Set<Integer> hs) {
		if (res.size() == Math.pow(2, n)) {
			return;
		}
		for (int i = 0; i < n; i++) {
			int temp = pre ^ (1 << i);
			if (!hs.contains(temp)) {
				res.add(temp);
				hs.add(temp);
				assist(temp, n, res, hs);
				// only need one valid result
			}
		}
	}
}
