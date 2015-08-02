package Solution;

public class JumpGame {
	public static boolean canJump(int[] A) {
		int curMax = A[0];
		for (int i = 1; i < A.length; i++) {
			if (curMax < i) {
				return false;
			}
			curMax = Math.max(curMax, i + A[i]);
			if (curMax >= A.length) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,1,4};
		System.out.println(canJump(A));
	}

}
