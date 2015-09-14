package Solution;

public class UpdateBits {
	public static int updateBits(int n, int m, int i, int j) {
		for (int pos = i; pos <= j; pos++) {
			int curm = m & 1;
			m = m >> 1;
			int curn = n & (1 << pos);
			if (curm == curn) {
				continue;
			}
			if (curm != 0 && curn == 0) {
				n = n | (1 << pos);
			}
			if (curm == 0 && curn != 0) {
				n = n ^ (1 << pos);
			}
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1024;
		int m = 21;
		System.out.println(updateBits(n, m, 2, 6));
	}

}
