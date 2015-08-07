package Solution;

public class TrailingZeros {
	public long trailingZeros(long n) {
		// prime factor 5
		long result = 0;
		while (n > 0) {
			result = result + n / 5;
			n /= 5;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
