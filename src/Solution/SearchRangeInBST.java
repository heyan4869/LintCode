// review traversal tree

package Solution;

import java.util.ArrayList;
import java.util.Stack;

public class SearchRangeInBST {
	public static ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> st = new Stack<TreeNode>();
		if (root == null) {
			return res;
		}
		TreeNode cur = root;
		while (true) {
			goLeft(cur, st);
			if (st.isEmpty()) {
				break;
			}
			TreeNode temp = st.pop();
			if (temp.val >= k1 && temp.val <= k2) {
				res.add(temp.val);
			}
			cur = temp.right;
		}
		return res;

	}

	private static void goLeft(TreeNode temp, Stack<TreeNode> st) {
		while (temp != null) {
			st.push(temp);
			temp = temp.left;
		}
	}

	// unsorted
	public static ArrayList<Integer> search(TreeNode root, int k1, int k2) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		assist(root, k1, k2, res);
		// no sort in lintcode
		res.sort(null);
		return res;
	}

	private static void assist(TreeNode root, int k1, int k2,
			ArrayList<Integer> res) {
		// TODO Auto-generated method stub
		if (root == null || root.val < k1 || root.val > k2) {
			return;
		}
		if (root.val > k1 && root.val < k2) {
			res.add(root.val);
			assist(root.left, k1, k2, res);
			assist(root.right, k1, k2, res);
		}
		if (root.val == k1) {
			res.add(root.val);
			assist(root.right, k1, k2, res);
		}
		if (root.val == k2) {
			res.add(root.val);
			assist(root.left, k1, k2, res);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		ArrayList<Integer> res = searchRange(root, 10, 22);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(" " + res.get(i) + " ");
		}
	}

}
