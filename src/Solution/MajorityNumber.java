package Solution;

import java.util.ArrayList;

public class MajorityNumber {
	public static int majorityNumber(ArrayList<Integer> nums) {
		int sum = 0;
		int major = 0;
		for (int i : nums) {
			if (sum == 0) {
				major = i;
				sum++;
			} else {
				if (i == major) {
					sum++;
				} else {
					sum--;
				}
			}
		}
		return major;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(1);
		nums.add(2);
		nums.add(1);
		nums.add(2);
		nums.add(2);
		nums.add(2);
		System.out.println(majorityNumber(nums));
	}

}
