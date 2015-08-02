package Solution;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorder {
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode cur = st.pop();
			res.add(cur.val);
			if (cur.right != null) {
				st.push(cur.right);
			}
			if (cur.left != null) {
				st.push(cur.left);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		ArrayList<Integer> res = preorderTraversal(root);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}

}
