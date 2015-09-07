package Solution;

public class PartitionArray {
	public static int partitionArray(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int i = 0, j = nums.length - 1;
		while (i <= j) {
			while (i <= j && nums[i] < k) {
				i++;
			}
			while (i <= j && nums[j] >= k) {
				j--;
			}
			if (i <= j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
