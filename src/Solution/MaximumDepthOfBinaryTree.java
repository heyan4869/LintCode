package Solution;

public class MaximumDepthOfBinaryTree {
	public static int maxDepth(TreeNode root) {
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
			return Math.max(assist(root.left, dep + 1), assist(root.right, dep + 1));
		}
		return -1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(4);
		System.out.println(maxDepth(root));
	}

}
