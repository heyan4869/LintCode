package Solution;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorder {
	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> st = new Stack<TreeNode>();
		if (root == null) {
			return res;
		}
		TreeNode p = root;
		while (p != null || !st.isEmpty()) {
			while (p != null) {
				st.push(p);
				p = p.left;
			}
			if (!st.isEmpty()) {
				p = st.pop();
				res.add(p.val);
				p = p.right;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		ArrayList<Integer> res = inorderTraversal(root);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}

	}

}
