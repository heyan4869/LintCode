// tricky

package Solution;

import java.util.ArrayList;

public class ContinuousSubarraySum {
	// TLE
	public static ArrayList<Integer> continuousSubarraySum(int[] A) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (A.length == 0) {
			return res;
		}
		int[] dp = new int[A.length];
		dp[0] = A[0];
		int tempMax;
		int tempSum;
		int tempIdx = 0;
		for (int i = 1; i < A.length; i++) {
			tempMax = Integer.MIN_VALUE;
			tempSum = 0;
			if (A[i] >= 0) {
				for (int j = i; j >= 0; j--) {
					tempSum += A[j];
					if (tempMax < tempSum && dp[i - 1] < tempSum) {
						tempMax = tempSum;
						tempIdx = j;
					}
				}
			}
			dp[i] = Math.max(tempMax, dp[i - 1]);
		}
		int curIdx = 0;
		int curSum = 0;
		for (int i = tempIdx; i < A.length; i++) {
			curSum += A[i];
			curIdx = i;
			if (curSum == dp[A.length - 1]) {
				break;
			}
		}
		res.add(tempIdx);
		res.add(curIdx);
		return res;
	}

	public static ArrayList<Integer> continuousSubarraySums(int[] A) {
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
		int[] A = { -3, 1, 3, -3, 4 };
		ArrayList<Integer> res = continuousSubarraySum(A);
		System.out.println(res);
	}

}
