package Solution;

public class LowestCommonAncestor {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null || A == null || B == null) {
			return null;
		}
		return assist(root, A, B);
	}

	private static TreeNode assist(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null || root == A || root == B) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, A, B);
		TreeNode right = lowestCommonAncestor(root.right, A, B);
		return left == null ? right : right == null ? left : root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}