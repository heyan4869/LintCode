package Solution;

public class MaximumProductSubarray {
	public static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], assist(nums, i));
		}
		return dp[nums.length - 1];
	}

	private static int assist(int[] nums, int i) {
		int maxProd = Integer.MIN_VALUE;
		int temp = 1;
		for (int idx = i; idx >= 0; idx--) {
			temp = temp * nums[idx];
			maxProd = Math.max(maxProd, temp);
		}
		return maxProd;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, -1, 4 };
		System.out.println(maxProduct(nums));
	}

}
