package Solution;

public class FindMissingNumber {
	public static int findMissing(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += i + 1;
			temp += nums[i];
		}
		return sum - temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3};
		System.out.println(findMissing(nums));
	}

}
