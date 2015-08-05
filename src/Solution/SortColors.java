package Solution;

public class SortColors {
	public static void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int head = 0;
		int tail = nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] == 2 && i < tail)
				swap(nums, i, tail--);
			while (nums[i] == 0 && i > head)
				swap(nums, i, head++);
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {0,2,2,2,2,1,0,1,0,0,0,1,0,2,0};
		sortColors(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
