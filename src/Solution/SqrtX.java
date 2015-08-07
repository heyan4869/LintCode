package Solution;

public class SqrtX {
	public static int sqrt(int x) {
		if (x < 0) {
			return -1;
		}
		if (x == 0 || x == 1) {
			return x;
		}
		return assist(x, 0, x);
	}

	private static int assist(int x, int start, int end) {
		if (start > end) {
			return -1;
		}
		// start is 0 at first, avoid overflow
		int mid = (start + end) / 2;
		if (Math.pow(mid, 2) <= x && Math.pow(mid + 1, 2) > x) {
			return mid;
		}
		if (Math.pow(mid, 2) < x) {
			return assist(x, mid + 1, end);
		}
		if (Math.pow(mid, 2) > x) {
			return assist(x, start, mid - 1);
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(14));
	}

}
