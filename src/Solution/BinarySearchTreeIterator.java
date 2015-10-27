package Solution;

import java.util.Stack;

public class BinarySearchTreeIterator {
	public static Stack<TreeNode> st;

	// @param root: The root of binary tree.
	public BinarySearchTreeIterator(TreeNode root) {
		// write your code here
		if (root == null) {
			return;
		}
		st = new Stack<TreeNode>();
		TreeNode backup = root;
		while (backup != null) {
			st.push(backup);
			backup = backup.left;
		}
	}

	// @return: True if there has next node, or false
	public boolean hasNext() {
		// write your code here
		return !st.isEmpty();
	}

	// @return: return next node
	public TreeNode next() {
		// write your code here
		TreeNode cur = st.pop();
		TreeNode res = cur;
		if (cur.right != null) {
			cur = cur.right;
			while (cur != null) {
				st.push(cur);
				cur = cur.left;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
