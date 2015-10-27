// hard

package Solution;

import java.util.Arrays;

public class MaximumGap {
	// use bucket sort
	public int maximumGap(int[] num) {
		if (num == null || num.length < 2)
			return 0;
		// get the max and min value of the array
		int min = num[0];
		int max = num[0];
		for (int i : num) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		// the minimum possibale gap, ceiling of the integer division
		int gap = (int) Math.ceil((double) (max - min) / (num.length - 1));
		// store min
		int[] bucketsMIN = new int[num.length - 1];
		// store max
		int[] bucketsMAX = new int[num.length - 1];
		Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
		Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
		// put numbers into buckets
		for (int i : num) {
			if (i == min || i == max) {
				continue;
			}
			// index of the right position in the buckets
			int idx = (i - min) / gap;
			bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
			bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
		}
		// scan the buckets for the max gap
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for (int i = 0; i < num.length - 1; i++) {
			if (bucketsMIN[i] == Integer.MAX_VALUE
					&& bucketsMAX[i] == Integer.MIN_VALUE) {
				// empty bucket
				continue;
			}
			// min value minus the previous value is the current gap
			maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
			// update previous bucket value
			previous = bucketsMAX[i];
		}
		// updata the final max value gap
		maxGap = Math.max(maxGap, max - previous);
		return maxGap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
