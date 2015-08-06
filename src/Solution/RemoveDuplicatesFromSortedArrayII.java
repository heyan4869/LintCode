package Solution;

public class RemoveDuplicatesFromSortedArrayII {
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int start = 0;
		boolean isRepeated = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[start]) {
				isRepeated = false;
				start++;
				nums[start] = nums[i];
			} else {
				if (isRepeated == false) {
					start++;
					nums[start] = nums[i];
					isRepeated = true;
				}
			}
		}
		return start + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 1, 1, 1, 2, 2, 3 };
		int len = removeDuplicates(nums);
		for (int i = 0; i < len; i++) {
			System.out.print(" " + nums[i] + " ");
		}
	}

}
