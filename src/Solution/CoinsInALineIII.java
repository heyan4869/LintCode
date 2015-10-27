package Solution;

public class CoinsInALineIII {
	public static int head;
	public static int tail;

	public static boolean firstWillWin(int[] values) {
		int len = values.length;
		if (len <= 1) {
			return true;
		}
		int[][] store = new int[len][len];
		int[][] sum = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				sum[i][j] = i == j ? values[j] : sum[i][j - 1] + values[j];
			}
		}
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (i == j) {
					store[i][j] = values[i];
				} else {
					int cur = Math.min(store[i + 1][j], store[i][j - 1]);
					store[i][j] = sum[i][j] - cur;
				}
			}
		}
		return store[0][len - 1] > sum[0][len - 1] - store[0][len - 1];
	}

	public static boolean check(int[] values) {
		if (values == null || values.length == 0) {
			return false;
		}
		if (values.length == 1) {
			return true;
		}
		int head = 0;
		int tail = values.length - 1;
		int first = 0;
		int i = 0;
		while (head <= tail) {
			if (i % 2 == 0) {
				if (values[head] >= values[tail]) {
					int temp = values[head];
					head++;
					first += temp;
				} else {
					int temp = values[tail];
					tail--;
					first += temp;
				}
			} else {
				if (values[head] >= values[tail]) {
					int temp = values[head];
					head++;
					first -= temp;
				} else {
					int temp = values[tail];
					tail--;
					first -= temp;
				}
			}
			i++;
		}
		return first > 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = new int[] { 1, 2, 4 };
		System.out.println(check(v));
	}

}
