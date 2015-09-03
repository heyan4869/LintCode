// tricky

package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSubarrayDifference {
	public static int maxDiffSubArrays(ArrayList<Integer> nums) {
		if (nums == null) {
			return 0;
		}
		int currMaxSum = 0, currMinSum = 0;
		int[] leftGlobalMax = new int[nums.size()];
		int[] leftGlobalMin = new int[nums.size()];
		for (int i = 0; i < nums.size() - 1; i++) {
			int localMax = currMaxSum + nums.get(i);
			int localMin = currMinSum + nums.get(i);
			if (i == 0) {
				// worked as initiation
				leftGlobalMax[i + 1] = localMax;
				leftGlobalMin[i + 1] = localMin;
			} else {
				leftGlobalMax[i + 1] = Math.max(localMax, leftGlobalMax[i]);
				leftGlobalMin[i + 1] = Math.min(localMin, leftGlobalMin[i]);
			}
			currMaxSum = Math.max(0, localMax);
			currMinSum = Math.min(0, localMin);
		}
		currMaxSum = 0;
		currMinSum = 0;
		int maxDiff = 0;
		for (int i = nums.size() - 1; i > 0; i--) {
			int localMax = currMaxSum + nums.get(i);
			int localMin = currMinSum + nums.get(i);
			// this is important
			int localMaxDiff = Math.max(leftGlobalMax[i] - localMin, localMax
					- leftGlobalMin[i]);
			maxDiff = Math.max(maxDiff, localMaxDiff);
			currMaxSum = Math.max(0, localMax);
			currMinSum = Math.min(0, localMin);
		}
		return maxDiff;
	}

	public static int maxDiffSubArray(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return -1;
		}
		int[] leftToRight = new int[nums.size()];
		int[] rightToLeft = new int[nums.size()];
		int maxLeft = Integer.MIN_VALUE / 2;
		int minRight = Integer.MAX_VALUE / 2;
		int maxDiff = Integer.MIN_VALUE / 2;
		for (int i = 0; i < nums.size(); i++) {
			maxLeft = Math.max(Math.max(nums.get(i), maxLeft + nums.get(i)),
					nums.get(i));
			leftToRight[i] = maxLeft;
		}
		for (int j = nums.size() - 1; j >= 0; j--) {
			minRight = Math.min(Math.min(nums.get(j), minRight + nums.get(j)),
					nums.get(j));
			rightToLeft[j] = minRight;
		}

		int tempLeftMax = Integer.MIN_VALUE / 2;
		int tempRightMin = Integer.MAX_VALUE / 2;
		int tempLeftMin = Integer.MAX_VALUE / 2;
		int tempRightMax = Integer.MIN_VALUE / 2;
		for (int i = 0; i < nums.size() - 1; i++) {
			tempLeftMax = Math.max(tempLeftMax, leftToRight[i]);
			tempRightMin = Math.min(tempRightMin, rightToLeft[i + 1]);
			maxDiff = Math.max(maxDiff, tempLeftMax - tempRightMin);
		}
		for (int i = nums.size() - 1; i >= 1; i--) {
			tempRightMax = Math.max(tempRightMax, leftToRight[i]);
			tempLeftMin = Math.min(tempLeftMin, rightToLeft[i - 1]);
			maxDiff = Math.max(maxDiff, tempRightMax - tempLeftMin);
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(-5, 3,
				-4, 0, 0, 0, -1, 20, 1, 1, -1, -1, -1, -1, -1));
		System.out.println(maxDiffSubArrays(nums));
	}

}
