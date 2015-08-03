package Solution;

public class ConvertSortedArrayToBSTWithMinimalHeight {
	public static TreeNode sortedArrayToBST(int[] A) {
		if (A == null || A.length == 0) {
			return null;
		}
		return assist(A, 0, A.length - 1);
	}

	private static TreeNode assist(int[] A, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode cur = new TreeNode(A[mid]);
		cur.left = assist(A, start, mid - 1);
		cur.right = assist(A, mid + 1, end);
		return cur;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
