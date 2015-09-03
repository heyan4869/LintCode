package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class ContinuousSubarraySumII {
	public static ArrayList<Integer> continuousSubarraySumII(int[] A) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (A.length == 0) {
			return res;
		}
		int allSum = 0;
		int maxIdx = -1;
		Boolean negFlag = true;
		int maxEle = Integer.MIN_VALUE;
		int curLeftForMax = 0;
		int maxLeft = 0;
		int maxRight = 0;
		int curSumForMax = 0;
		int maxSum = Integer.MIN_VALUE;

		int curLeftForMin = 0;
		int minLeft = 0;
		int minRight = 0;
		int curSumForMin = 0;
		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > maxEle) {
				maxEle = A[i];
				maxIdx = i;
			}
			if (A[i] > 0) {
				negFlag = false;
			}
			allSum += A[i];
			curSumForMax += A[i];
			curSumForMin += A[i];
			// max
			if (curSumForMax > maxSum) {
				maxLeft = curLeftForMax;
				maxRight = i;
				maxSum = curSumForMax;
			}
			if (curSumForMax < 0) {
				if (i + 1 <= A.length - 1) {
					curSumForMax = 0;
					curLeftForMax = i + 1;
				}
			}

			// min
			if (curSumForMin < minSum) {
				minLeft = curLeftForMin;
				minRight = i;
				minSum = curSumForMin;
			}
			if (curSumForMin > 0) {
				if (i + 1 <= A.length - 1) {
					curSumForMin = 0;
					curLeftForMin = i + 1;
				}
			}
		}
		if (negFlag) {
			res.add(maxIdx);
			res.add(maxIdx);
			return res;
		}
		if (maxSum >= allSum - minSum) {
			res.add(maxLeft);
			res.add(maxRight);
			return res;
		} else {
			res.add(minRight + 1);
			res.add(minLeft - 1);
			return res;
		}
	}

	// got several wrong answer
	public static ArrayList<Integer> continuousSubarraySumTwo(int[] A) {
		int[] extendA = Arrays.copyOf(A, A.length * 2);
		System.arraycopy(A, 0, extendA, A.length, A.length);
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (A.length == 0) {
			return res;
		}
		int curLeft = 0;
		int maxLeft = curLeft;
		int maxRight = 0;
		int curSum = 0;
		int maxSum = Integer.MIN_VALUE;
		int len = 0;
		for (int i = 0; i < extendA.length; i++) {
			if (len < A.length) {
				curSum += extendA[i];
				if (curSum > maxSum) {
					maxLeft = curLeft;
					maxRight = i;
					maxSum = curSum;
					len++;
				}
				if (curSum < 0) {
					if (i + 1 <= extendA.length - 1) {
						curSum = 0;
						curLeft = i + 1;
						len = 0;
					}
				}
			}
		}
		if (maxLeft >= A.length) {
			maxLeft = maxLeft % A.length;
		}
		if (maxRight >= A.length) {
			maxRight = maxRight % A.length;
		}
		res.add(maxLeft);
		res.add(maxRight);
		return res;
	}

	public static void main(String[] args) {
		int[] A = { -101,-33,-44,-55,-67,-78,-101,-33,-44,-55,-67,-78,-100,-200,-1000,-22,-100,-200,-1000,-22};
		ArrayList<Integer> res = continuousSubarraySumII(A);
		System.out.println(res);
	}

}
