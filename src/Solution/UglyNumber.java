// tricky

package Solution;

public class UglyNumber {
	public static long kthPrimeNumber(int k) {
		long[] result = new long[k + 1];
		int p3 = 0;
		int p5 = 0;
		int p7 = 0;
		result[0] = 1;

		for (int i = 1; i <= k; i++) {
			long num = Math.min(Math.min(result[p3] * 3, result[p5] * 5),
					result[p7] * 7);
			if (num / result[p3] == 3) {
				p3++;
			}
			if (num / result[p5] == 5) {
				p5++;
			}
			if (num / result[p7] == 7) {
				p7++;
			}
			result[i] = num;
		}
		return result[k];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
