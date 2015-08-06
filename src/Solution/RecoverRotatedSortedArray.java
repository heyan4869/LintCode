package Solution;

import java.util.ArrayList;

public class RecoverRotatedSortedArray {
	public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0 || nums.size() == 1) {
			return;
		}
		int len = nums.size();
		while (len > 0) {
			if (nums.get(0) > nums.get(1)) {
				int temp = nums.get(0);
				nums.remove(0);
				nums.add(temp);
				break;
			} else {
				int temp = nums.get(0);
				nums.remove(0);
				nums.add(temp);
				len--;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<>();
//		nums.add(4);
//		nums.add(5);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		recoverRotatedSortedArray(nums);
		for (int i = 0; i < nums.size(); i++) {
			System.out.print(" " + nums.get(i) + " ");
		}
	}

}
