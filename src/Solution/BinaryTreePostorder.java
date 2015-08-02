package Solution;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorder {
	public static ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		TreeNode cur = null;
		while (!st.isEmpty()) {
			cur = st.peek();
			if (cur.left == null && cur.right == null) {
				res.add(cur.val);
				st.pop();
			} else {
				if (cur.right != null) {
					st.push(cur.right);
					cur.right = null;
				}
				if (cur.left != null) {
					st.push(cur.left);
					cur.left = null;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
