package Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class MaxTree {
	public static TreeNode maxTree(int[] A) {
		if (A == null || A.length == 0) {
			return null;
		}
		TreeNode head = new TreeNode(A[0]);
		TreeNode root = head;
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(head);
		for (int i = 1; i < A.length; i++) {
			TreeNode cur = new TreeNode(A[i]);
			if (cur.val > root.val) {
				root = cur;
			}
			if (cur.val > st.peek().val) {
				TreeNode top = st.pop();
				while (!st.isEmpty() && st.peek().val < cur.val) {
					TreeNode pre = st.pop();
					pre.right = top;
					top = pre;
				}
				cur.left = top;
				st.push(cur);	
			} else {
				st.push(cur);
			}
		}
		TreeNode cur = st.pop();
		while (!st.isEmpty()) {
			TreeNode next = st.pop();
			next.right = cur;
			cur = next;
		}
		return root;
	}

	// reuse level order traversal

	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return res;
		}
		Set<Integer> hs = new HashSet<Integer>();
		assist(root, 1, hs, res);
		return res;
	}

	private static void assist(TreeNode root, int level, Set<Integer> hs,
			ArrayList<ArrayList<Integer>> res) {
		if (root == null) {
			return;
		}
		if (!hs.contains(level)) {
			hs.add(level);
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(root.val);
			res.add(temp);
			assist(root.left, level + 1, hs, res);
			assist(root.right, level + 1, hs, res);
		} else {
			res.get(level - 1).add(root.val);
			assist(root.left, level + 1, hs, res);
			assist(root.right, level + 1, hs, res);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 5, 6, 0, 3, 1 };
		TreeNode res = maxTree(A);
		ArrayList<ArrayList<Integer>> al = levelOrder(res);
		for (int i = 0; i < al.size(); i++) {
			List<Integer> cur = al.get(i);
			for (int j = 0; j < cur.size(); j++) {
				System.out.print(" " + cur.get(j) + " ");
			}
			System.out.println();
		}
	}

}
