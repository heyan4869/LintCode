package Solution;

public class PermutationSequence {
	public static String getPermutation(int n, int k) {
		boolean[] output = new boolean[n];
		StringBuilder buf = new StringBuilder("");
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * i;
		}
		for (int i = n - 1; i >= 0; i--) {
			int s = 1;
			while (k > res[i]) {
				s++;
				k = k - res[i];
			}
			for (int j = 0; j < n; j++) {
				if (j + 1 <= s && output[j]) {
					s++;
				}
			}
			output[s - 1] = true;
			buf.append(Integer.toString(s));
		}
		return buf.toString();
	}

	public static String getPermutate(int n, int k) {
		if (n == 0 || k == 0) {
			return null;
		}
		String res = "";
		boolean[] flag = new boolean[n];
		return assist(res, n, k, 1, flag);
	}

	private static String assist(String res, int n, int k, int preIdx,
			boolean[] flag) {
		if (n == 0) {
			return res;
		}
		int idx = k / (fact(n) / n);
		int idxbackup = idx;
		int temp = 0;
		for (int i = 0; i < flag.length; i++) {
			if (idx == 0) {
				break;
			}
			if (flag[i] == false) {
				idx--;
			}
			temp = i;
		}
		res += temp + 1;
		flag[temp] = true;
		return assist(res, n - 1, k / idxbackup, idxbackup, flag);
	}

	private static int fact(int num) {
		int val = 1;
		for (int i = 1; i <= num; i++) {
			val *= i;
		}

		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(3, 1));
	}

}
