package Solution;

public class FlipBits {
	public static int bitSwapRequired(int a, int b) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((a & (1 << i)) != (b & (1 << i))) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bitSwapRequired(31, 14));
	}

}
