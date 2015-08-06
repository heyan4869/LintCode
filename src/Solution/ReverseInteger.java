package Solution;

public class ReverseInteger {
	public static int reverseInteger(int n) {
		boolean flag = false;
		if (n < 0) {
			flag = true;
			n = Math.abs(n);
		}
		String str = n + "";
		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse += str.charAt(i);
		}
		double res = Double.parseDouble(reverse);
		if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
			return 0;
		} else {
			return (int) (flag ? 0 - res : res);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseInteger(11474837));
	}

}
