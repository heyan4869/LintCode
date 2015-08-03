package Solution;

public class DigitCounts {
	public static int digitCounts(int k, int n) {
		String str = "";
		for (int i = 0; i <= n; i++) {
			str += i;
		}
		int count = 0;
		String temp = String.valueOf(k);
		char c = temp.charAt(0);
		for (int i = 0; i < str.length(); i++) {
			if (c == str.charAt(i)) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(digitCounts(1, 12));
	}

}
