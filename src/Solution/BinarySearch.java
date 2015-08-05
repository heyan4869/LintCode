package Solution;

public class BinarySearch {
	public static int binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
        return assist(nums, target, 0, nums.length - 1);
    }

	private static int assist(int[] nums, int target, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == target && mid >= 1 && nums[mid - 1] < target) {
			return mid;
		} else if (nums[mid] == target && mid == 0) {
			return mid;
		}
		if (nums[mid] >= target) {
			return assist(nums, target, start, mid - 1);
		}
		if (nums[mid] < target) {
			return assist(nums, target, mid + 1, end);
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 2, 3, 3, 4, 5, 10};
		System.out.println(binarySearch(nums, 2));
	}

}
