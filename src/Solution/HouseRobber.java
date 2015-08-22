package Solution;

public class HouseRobber {
	// O(1) space
	public long houseRobber(int[] A) {
		// write your code here
		long even = 0;
		long odd = 0;
		for (int i = 0; i < A.length; i++) {
			if (i % 2 == 0) {
				even = even + A[i];
				even = even > odd ? even : odd;
			} else {
				odd = odd + A[i];
				odd = even > odd ? even : odd;
			}
		}
		return even > odd ? even : odd;
	}
}
