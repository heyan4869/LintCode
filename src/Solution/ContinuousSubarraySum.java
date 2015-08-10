// tricky

package Solution;

import java.util.ArrayList;

public class ContinuousSubarraySum {
	public static ArrayList<Integer> continuousSubarraySum(int[] A) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (A.length == 0) {
			return res;
		}
		int curLeft = 0;
		int maxLeft = curLeft;
		int maxRight = 0;
		int curSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			curSum += A[i];
			if (curSum > maxSum) {
				maxLeft = curLeft;
				maxRight = i;
				maxSum = curSum;
			}
			if (curSum < 0) {
				if (i + 1 <= A.length - 1) {
					curSum = 0;
					curLeft = i + 1;
				}
			}
		}
		res.add(maxLeft);
		res.add(maxRight);
		return res;
	}

	public static void main(String[] args) {
		int[] A= {-3, 1, 3, -3, 4};
		ArrayList<Integer> res = continuousSubarraySum(A);
		System.out.println(res);
	}

}
