package Solution;

public class SearchInRotatedSortedArrayII {
	public static boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int length = nums.length;
		return assist(nums, target, 0, length - 1);
	}
	
	// this is O(n), since it ignored the fact of rotated sorted array
	public static boolean assist(int[] nums, int target, int start, int end) {
		if (start > end) {
			return false;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == target) {
			return true;
		}
		return assist(nums, target, start, mid - 1)
				|| assist(nums, target, mid + 1, end);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
