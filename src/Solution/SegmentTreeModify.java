package Solution;

import java.util.Stack;

public class SegmentTreeModify {
	public static void modify(SegmentTreeNode root, int index, int value) {
		if (root == null) {
			return;
		}
		Stack<SegmentTreeNode> st = new Stack<SegmentTreeNode>();
		assist(root, index, value, st);
		while (!st.isEmpty()) {
			SegmentTreeNode cur = st.pop();
			cur.max = Math.max(cur.left.max, cur.right.max);
		}
	}

	private static void assist(SegmentTreeNode root, int index, int value, Stack<SegmentTreeNode> st) {
		if (root == null) {
			return;
		}
		if (index == root.start && index == root.end) {
			root.max = value;
			return;
		}
		st.push(root);
		if ((root.start + root.end) / 2 >= index) {
			assist(root.left, index, value, st);
		}
		if ((root.start + root.end) / 2 + 1 <= index) {
			assist(root.right, index, value, st);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SegmentTreeNode root = new SegmentTreeNode(0, 3, 4);
		root.left = new SegmentTreeNode(0, 1, 4);
		root.left.left = new SegmentTreeNode(0, 0, 1);
		root.left.right = new SegmentTreeNode(1, 1, 4);
		root.right = new SegmentTreeNode(2, 3, 3);
		root.right.left = new SegmentTreeNode(2, 2, 2);
		root.right.right = new SegmentTreeNode(3, 3, 3);
		modify(root, 3, 6);
		System.out.println(root.max);
	}

}
