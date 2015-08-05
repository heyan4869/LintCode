package Solution;

public class LongestIncreasingContinuousSubsequence {
	public static int longestIncreasingContinuousSubsequence(int[] A) {
		if (A.length == 0) {
			return 0;
		}
		int[] dp = new int[A.length];
		dp[0] = 1;
		int leftToRight = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1]) {
				dp[i] = dp[i - 1] + 1;
				leftToRight = Math.max(leftToRight, dp[i]);
			} else {
				dp[i] = 1;
			}
		}
		
		int rightToLeft = 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				dp[i] = dp[i - 1] + 1;
				rightToLeft = Math.max(rightToLeft, dp[i]);
			} else {
				dp[i] = 1;
			}
		}
		return Math.max(leftToRight, rightToLeft);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 5, 1, 2, 3, 4 };
		System.out.println(longestIncreasingContinuousSubsequence(A));
	}

}
