package Solution;

public class NextPermutation {
	public static int[] nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return nums;
		}
		int partitionIdx = -1;
		int cur = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < cur) {
				partitionIdx = i;
				break;
			} else {
				cur = nums[i];
			}
		}
		if (partitionIdx == -1) {
			for (int i = 0; i < nums.length / 2; i++) {
				swap(nums, i, nums.length - 1 - i);
			}
			return nums;
		}
		int changeIdx = -1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] > nums[partitionIdx]) {
				changeIdx = i;
				break;
			}
		}
		swap(nums, partitionIdx, changeIdx);
		for (int i = 0; i <= (nums.length - partitionIdx - 2) / 2; i++) {
			swap(nums, partitionIdx + 1 + i, nums.length - 1 - i);
		}
		return nums;
	}

	private static void swap(int[] nums, int partitionIdx, int changeIdx) {
		int temp = nums[partitionIdx];
		nums[partitionIdx] = nums[changeIdx];
		nums[changeIdx] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,0};
		int[] res = nextPermutation(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

}