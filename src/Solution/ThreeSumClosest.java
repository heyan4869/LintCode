package Solution;

import java.util.Arrays;

public class ThreeSumClosest {
	// O(n^2) time
	public static int threeSumClosest(int[] numbers, int target) {
		int res = Integer.MAX_VALUE;
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length - 2; i++) {
			for (int j = i + 1; j < numbers.length - 1; j++) {
				int tail = numbers.length - 1;
				while (tail > j) {
					int temp = numbers[i] + numbers[j] + numbers[tail];
					if (Math.abs(temp - target) < Math.abs(res - target)) {
						res = temp;
					}
					if (temp > target) {
						tail--;
					} else {
						break;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = { 2, 7, 11, 15 };
		System.out.println(threeSumClosest(n, 3));
	}

}