package Solution;

import java.util.Arrays;

public class PlusOne {
	public static int[] plusOne(int[] digits) {
		int[] res = new int[digits.length + 1];
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int temp = digits[i] + carry;
			res[i + 1] = temp % 10;
			carry = temp / 10;
		}
		if (carry != 0) {
			res[0] = carry;
			return res;
		} else {
			return Arrays.copyOfRange(res, 1, res.length);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = {9, 9, 9};
		int[] res = plusOne(digits);
		for (int i = 0; i < res.length; i++) {
			System.out.print(" " + res[i] + " ");
		}
	}

}
