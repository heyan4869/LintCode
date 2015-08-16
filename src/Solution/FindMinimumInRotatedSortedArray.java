package Solution;

public class FindMinimumInRotatedSortedArray {
	public static int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		if (num.length == 1) {
			return num[0];
		}
		if (num.length == 2) {
			if (num[0] > num[1]) {
				return num[1];
			} else {
				return num[0];
			}
		}
		return assist(num, 0, num.length - 1);
	}

	private static int assist(int[] num, int start, int end) {
		if (start > end) {
			return -1;
		}
		// incase only two element left
		if (end - start == 1 && num[start] > num[end]) {
			return num[end];
		}
		// compare the start, mid, end
		int mid = (start + end) / 2;
		if (num[mid] < num[mid - 1]) {
			return num[mid];
		}
		if (num[start] < num[mid] && num[mid] > num[end]) {
			return assist(num, mid, end);
		}
		if (num[start] > num[mid] && num[mid] < num[end]) {
			return assist(num, start, mid);
		}
		// incase the array is sorted
		if (num[start] < num[mid] && num[mid] < num[end]) {
			return num[start];
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 7, 2, 3, 5 };
		System.out.println(findMin(num));
	}

}
