package Solution;

public class Test {
	public static int find(int[] a) {
		return assist(a, 0, a.length - 1);
	}

	private static int assist(int[] a, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (a[mid] == 1 && a[mid - 1] == 0) {
			return mid;
		}
		if (a[mid] == 0) {
			return assist(a, mid + 1, end);
		}
		if (a[mid] == 1) {
			return assist(a, start, mid - 1);
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0, 0, 1};
		System.out.println(find(a));
	}

}
