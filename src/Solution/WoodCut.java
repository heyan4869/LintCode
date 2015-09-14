package Solution;

public class WoodCut {
	public static int woodCut(int[] L, int k) {
		if (L == null || L.length == 0) {
			return 0;
		}
		int maxLen = Integer.MIN_VALUE;
		for (int i = 0; i < L.length; i++) {
			maxLen = Math.max(maxLen, L[i]);
		}
		// start should be 1, in case of dividing by 0
		return assist(L, k, 1, maxLen, 0);
	}

	private static int assist(int[] L, int k, int start, int end, int res) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		int piece = 0;
		for (int i = 0; i < L.length; i++) {
			piece += L[i] / mid;
		}
		if (piece >= k) {
			res = Math.max(res, mid);
			res = Math.max(res, assist(L, k, mid + 1, end, res));
			return res;
		} else {
			res = Math.max(res, assist(L, k, start, mid - 1, res));
			return res;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] L = { 2147483644, 2147483645, 2147483646, 2147483647 };
		System.out.println(woodCut(L, 4));
	}

}
