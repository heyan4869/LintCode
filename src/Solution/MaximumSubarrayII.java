package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSubarrayII {
	public static int maxTwoSubArrays(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return 0;
		}
		int curLeftMax = 0;
		int curRightMax = 0;
		int[] globalLeftMax = new int[nums.size()];
		int[] globalRightMax = new int[nums.size()];
		for (int i = 0; i < nums.size(); i++) {
			int localLeftMax = curLeftMax + nums.get(i);
			if (i == 0) {
				globalLeftMax[i] = localLeftMax;
			} else {
				globalLeftMax[i] = Math.max(localLeftMax, globalLeftMax[i - 1]);
			}
			curLeftMax = Math.max(0, localLeftMax);
		}
		for (int j = nums.size() - 1; j >= 0; j--) {
			int localRightMax = curRightMax + nums.get(j);
			if (j == nums.size() - 1) {
				globalRightMax[j] = localRightMax;
			} else {
				globalRightMax[j] = Math.max(localRightMax,
						globalRightMax[j + 1]);
			}
			curRightMax = Math.max(0, localRightMax);
		}
		
		int maxDiff = globalLeftMax[0] + globalRightMax[1];
		for (int i = 1; i < nums.size() - 1; i++) {
			maxDiff = Math.max(maxDiff, globalLeftMax[i] + globalRightMax[i + 1]);
		}
		
		return maxDiff;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(-1, -1));
		System.out.println(maxTwoSubArrays(nums));
	}

}
