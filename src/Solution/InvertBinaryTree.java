package Solution;

public class InvertBinaryTree {
	public static void invertBinaryTree(TreeNode root) {
		if (root == null) {
			return;
		}
		assist(root);
	}

	private static void assist(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		assist(root.left);
		assist(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
