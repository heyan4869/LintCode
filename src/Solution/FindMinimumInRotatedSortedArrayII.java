package Solution;

public class FindMinimumInRotatedSortedArrayII {
	public static int findMin(int[] num) {
		return assist(num, 0, num.length - 1);
	}

	public static int assist(int[] num, int left, int right) {
		if (right - left <= 1) {
			return num[left] < num[right] ? num[left] : num[right];
		}
		int mid = (right + left) / 2;
		if (num[mid] < num[right]) {
			return assist(num, left, mid);
		} else if (num[mid] > num[right]) {
			return assist(num, mid, right);
		} else {
			// important
			int leftMin = assist(num, left, mid);
			int rightMin = assist(num, mid, right);
			return leftMin < rightMin ? leftMin : rightMin;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = { 1, 4, 4, 5, 6 };
		System.out.println(findMin(num));
	}

}
