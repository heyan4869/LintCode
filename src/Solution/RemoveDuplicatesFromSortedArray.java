package Solution;

public class RemoveDuplicatesFromSortedArray {
	// reference
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return nums.length;
		int cur = 0, next = 1;
		while (next < nums.length) {
			if (nums[cur] == nums[next]) {
				next++;
			} else {
				cur++;
				nums[cur] = nums[next];
				next++;
			}
		}
		return cur + 1;
	}

	// mine solution
	public static int removeDuplicate(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
		int cur = 0;
		int next = 1;
		while (next < nums.length) {
			if (cur < nums.length - 1 && nums[cur] < nums[cur + 1]) {
				cur++;
			} else {
				while (next < nums.length - 1 && nums[cur] >= nums[next]) {
					next++;
				}
				if (next >= nums.length - 1) {
					break;
				}
				nums[cur + 1] = nums[next];
				cur++;
			}
		}
		if (nums[cur] != nums[next] && nums[cur + 1] < nums[next]) {
			nums[cur + 1] = nums[next];
			return cur + 2;
		}
		return cur + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 2, 3, 4, 4 };
		int len = removeDuplicates(nums);
		for (int i = 0; i < len; i++) {
			System.out.print(" " + nums[i] + " ");
		}
	}

}
