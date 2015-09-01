package Solution;

import java.util.ArrayList;

public class MajorityNumberII {
	public static int majorityNumber(ArrayList<Integer> nums) {
		int candidate1 = 0;
		int candidate2 = 0;
		int count1 = 0;
		int count2 = 0;
		for (int elem : nums) {
			if (count1 == 0) {
				candidate1 = elem;
			}
			if (count2 == 0 && elem != candidate1) {
				candidate2 = elem;
			}
			if (candidate1 == elem) {
				count1++;
			}
			if (candidate2 == elem) {
				count2++;
			}
			if (candidate1 != elem && candidate2 != elem) {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;
		for (int elem : nums) {
			if (elem == candidate1) {
				count1++;
			} else if (elem == candidate2) {
				count2++;
			}
		}
		return count1 > count2 ? candidate1 : candidate2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(1);
		nums.add(2);
		nums.add(1);
		nums.add(3);
		nums.add(3);

		System.out.println(majorityNumber(nums));
	}

}
