package Solution;

public class InsertNodeInBST {
	public static TreeNode insertNode(TreeNode root, TreeNode node) {
		if (root == null)
			return node;
		TreeNode temp = root;
		while (true) {
			if (node.val > temp.val) {
				if (temp.right == null) {
					temp.right = node;
					return root;
				} else {
					temp = temp.right;
				}
			} else {
				if (temp.left == null) {
					temp.left = node;
					return root;
				} else {
					temp = temp.left;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
