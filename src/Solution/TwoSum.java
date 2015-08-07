package Solution;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	// O(n) time and space
	public static int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			if (!hm.containsKey(numbers[i])) {
				hm.put(target - numbers[i], i);
			} else {
				res[0] = hm.get(numbers[i]) + 1;
				res[1] = i + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
