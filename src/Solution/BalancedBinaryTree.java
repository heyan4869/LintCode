package Solution;

public class BalancedBinaryTree {
	public static boolean flag = true;

	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		assist(root, 0);
		return flag;
	}

	private static int assist(TreeNode root, int pre) {
		if (root == null) {
			return pre;
		}
		int left = assist(root.left, pre + 1);
		int right = assist(root.right, pre + 1);
		if (Math.abs(left - right) > 1) {
			flip();
		}
		return Math.max(left, right);
	}

	private static void flip() {
		flag = false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(0);
		System.out.println(isBalanced(root));
	}

}
