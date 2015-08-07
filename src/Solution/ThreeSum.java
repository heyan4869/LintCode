package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length - 2; i++) {
			int head = i + 1;
			int tail = numbers.length - 1;
			while (head < tail) {
				int temp = numbers[i] + numbers[head] + numbers[tail];
				if (temp == 0) {
					ArrayList<Integer> cur = new ArrayList<Integer>();
					cur.add(numbers[i]);
					cur.add(numbers[head]);
					cur.add(numbers[tail]);
					if (!res.contains(cur)) {
						res.add(new ArrayList<Integer>(cur));
					}
					head++;
					tail--;
				}
				if (temp < 0) {
					head++;
				}
				if (temp > 0) {
					tail--;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = { -1, 0, 1, 2, -1, -4 };
		ArrayList<ArrayList<Integer>> res = threeSum(n);
		for (int i = 0; i < res.size(); i++) {
			ArrayList<Integer> temp = res.get(i);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(" " + temp.get(j) + " ");
			}
			System.out.println("");
		}
	}

}
