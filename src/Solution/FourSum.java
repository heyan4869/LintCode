package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	public static ArrayList<ArrayList<Integer>> fourSum(int[] numbers,
			int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length - 3; i++) {
			for (int j = i + 1; j < numbers.length - 2; j++) {
				int head = j + 1;
				int tail = numbers.length - 1;
				while (head < tail) {
					int cur = numbers[i] + numbers[j] + numbers[head]
							+ numbers[tail];
					if (cur == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(numbers[i]);
						temp.add(numbers[j]);
						temp.add(numbers[head]);
						temp.add(numbers[tail]);
						if (!res.contains(temp)) {
							res.add(new ArrayList<Integer>(temp));
						}
						head++;
						tail--;
					}
					if (cur < target) {
						head++;
					}
					if (cur > target) {
						tail--;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 1, 0, -1, 0, -2, 2 };
		ArrayList<ArrayList<Integer>> res = fourSum(numbers, 0);
		for (int i = 0; i < res.size(); i++) {
			ArrayList<Integer> temp = res.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(" " + temp.get(j) + " ");
			}
			System.out.println("");
		}
	}

}
