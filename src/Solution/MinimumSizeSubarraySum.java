package Solution;

public class MinimumSizeSubarraySum {
	public static int minimumSize(int[] nums, int s) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			if (nums[0] >= s) {
				return 1;
			} else {
				return -1;
			}
		}
		int p1 = 0;
		int p2 = 1;
		int minLen = Integer.MAX_VALUE;
		int curSum = nums[0];
		if (curSum >= s) {
			return 1;
		}
		while (p2 < nums.length) {
			curSum += nums[p2];
			if (curSum >= s) {
				minLen = Math.min(minLen, p2 - p1 + 1);
				while (curSum >= s) {
					if (curSum - nums[p1] >= s) {
						curSum = curSum - nums[p1];
						p1++;
						minLen = Math.min(minLen, p2 - p1 + 1);
					} else {
						p2++;
						break;
					}
				}
			} else {
				p2++;
			}
		}
		return minLen == Integer.MAX_VALUE ? -1 : minLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2113, 1, 1 };
		System.out.println(minimumSize(nums, 12345));
	}

}
