package Solution;

public class PartitionArrayByOddAndEven {
	public static void partitionArray(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			while (low <= nums.length - 1 && nums[low] % 2 == 1) {
				low++;
			}
			while (high >= 0 && nums[high] % 2 == 0) {
				high--;
			}
			if (low < high) {
				swap(nums, low, high);
			}
		}
	}

	private static void swap(int[] nums, int low, int high) {
		// TODO Auto-generated method stub
		int temp = nums[low];
		nums[low] = nums[high];
		nums[high] = temp;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
