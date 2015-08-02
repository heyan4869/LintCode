package Solution;

import java.util.ArrayList;

public class MinimumSubarray {
	public static int minSubArray(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return Integer.MIN_VALUE;
		}
		int curMin = Integer.MAX_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			int sum = 0;
			for (int j = i; j < nums.size(); j++) {
				sum += nums.get(j);
				curMin = Math.min(curMin, sum);
			}
		}
		return curMin;
	}

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(-1);
		nums.add(-2);
		nums.add(1);
		System.out.println(minSubArray(nums));
	}

}
