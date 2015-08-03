// tricky

package Solution;

import java.util.ArrayList;

public class MaximumSubarray {
	public static int maxSubArray(ArrayList<Integer> nums) {
		if (nums.size() == 0) {
			return 0;
		}
		int maxEndingHere = nums.get(0);
		int curMax = nums.get(0);
		for (int i = 1; i < nums.size(); i++) {
			if (maxEndingHere < 0)
				// so far we get negative values, this part has to be dropped
				maxEndingHere = nums.get(i);
			else
				// we can accept it, it could grow later
				maxEndingHere += nums.get(i);

			curMax = Math.max(curMax, maxEndingHere);
		}
		return curMax;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
