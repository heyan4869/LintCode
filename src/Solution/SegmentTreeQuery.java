package Solution;

public class SegmentTreeQuery {
	private static int maxnum = Integer.MIN_VALUE;

	public static int query(SegmentTreeNode root, int start, int end) {
		assist(root, start, end);
		return maxnum;
	}

	private static void assist(SegmentTreeNode root, int start, int end) {
		if (root == null || start > root.end || end < root.start) {
			return;
		}
		if ((start == root.start && end == root.end)
				|| (start <= root.start && end >= root.end)) {
			check(root);
			return;
		}
		if ((root.start + root.end) / 2 >= start) {
			assist(root.left, start, end);
		}
		if ((root.start + root.end) / 2 + 1 <= end) {
			assist(root.right, start, end);
		}
		return;
	}

	private static void check(SegmentTreeNode root) {
		maxnum = Math.max(maxnum, root.max);
	}

	public static void main(String[] args) {
		SegmentTreeNode root = new SegmentTreeNode(0, 3, 4);
		root.left = new SegmentTreeNode(0, 1, 4);
		root.left.left = new SegmentTreeNode(0, 0, 1);
		root.left.right = new SegmentTreeNode(1, 1, 4);
		root.right = new SegmentTreeNode(2, 3, 3);
		root.right.left = new SegmentTreeNode(2, 2, 2);
		root.right.right = new SegmentTreeNode(3, 3, 3);
		System.out.println(query(root, 2, 2));
	}

}
