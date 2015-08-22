// tricky

package Solution;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		int maxlen = 0;
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			if (hm.containsKey(num[i])) {
				continue;
			}
			hm.put(num[i], 1);
			int end = num[i];
			int begin = num[i];
			if (hm.containsKey(num[i] + 1)) {
				end = num[i] + hm.get(num[i] + 1);
			}
			if (hm.containsKey(num[i] - 1)) {
				begin = num[i] - hm.get(num[i] - 1);
			}
			hm.put(end, end - begin + 1);
			hm.put(begin, end - begin + 1);
			maxlen = Math.max(maxlen, end - begin + 1);
		}
		return maxlen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
