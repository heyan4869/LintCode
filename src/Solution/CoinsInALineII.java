package Solution;

public class CoinsInALineII {
	public static boolean firstWillWin(int[] values) {
		int val1 = 0, val2 = 0;
		boolean turn = true;
		int i = 0;
		// pick one first, then compare the next and the next next
		// decide whether to pick up another
		while (i < values.length) {
			if (turn) {
				val1 += values[i];
				i++;
				if (i < values.length
						&& (i + 1 >= values.length || values[i] >= values[i + 1])) {
					val1 += values[i];
					i++;
				}
				turn = !turn;
			} else {
				val2 += values[i];
				i++;
				if (i < values.length
						&& (i + 1 >= values.length || values[i] >= values[i + 1])) {
					val2 += values[i];
					i++;
				}
				turn = !turn;
			}
		}
		return val1 > val2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = { 1, 2, 4 };
		System.out.println(firstWillWin(values));
	}
}
