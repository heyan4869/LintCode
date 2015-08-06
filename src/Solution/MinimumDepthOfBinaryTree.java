package Solution;

public class MinimumDepthOfBinaryTree {
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return assist(root, 1);
	}

	private static int assist(TreeNode root, int dep) {
		if (root.left == null && root.right == null) {
			return dep;
		}
		if (root.left != null && root.right == null) {
			return assist(root.left, dep + 1);
		}
		if (root.left == null && root.right != null) {
			return assist(root.right, dep + 1);
		}
		if (root.left != null && root.right != null) {
			return Math.min(assist(root.left, dep + 1),
					assist(root.right, dep + 1));
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
