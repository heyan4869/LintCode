package Solution;

public class JumpGameII {
	public static int jump(int[] A) {
		int curMax = A[0];
		int step = 0;
		for (int i = 1; i < A.length; i++) {
			if (curMax < i) {
				return -1;
			}
			// check if can jump first
			if (curMax >= A.length - 1) {
				return step + 1;
			}
			int temp = curMax;
			curMax = Math.max(curMax, i + A[i]);
			if (curMax == i + A[i] && curMax != temp) {
				step++;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 3,52,42,21,58 };
		System.out.println(jump(A));
	}

}
