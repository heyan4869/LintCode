// tricky

package Solution;

public class LongestIncreasingSubsequence {
	public static int longestIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			int maxn = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] <= nums[i] && dp[j] > maxn) {
					maxn = dp[j];
				}
			}
			dp[i] = maxn + 1;
		}
		int maxi = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > maxi) {
				maxi = dp[i];
			}
		}
		return maxi;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 2, 2, 2 };
		System.out.println(longestIncreasingSubsequence(nums));
	}

}
