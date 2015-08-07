package Solution;

import java.util.ArrayList;

public class SubarraySum {
	public static ArrayList<Integer> subarraySum(int[] nums) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == 0) {
					res.add(i);
					res.add(j);
					return res;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-3, 1, 2, -3, 4};
		ArrayList<Integer> res = subarraySum(nums);
		System.out.println(res.get(0) + " " + res.get(1));
	}

}
