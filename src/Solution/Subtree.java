// tricky

package Solution;

public class Subtree {
	public static boolean isSubtree(TreeNode T1, TreeNode T2) {
		boolean res = false;
		if (T2 == null) {
			return true;
		}
		if (T1 == null) {
			return false;
		}
		if (T1.val == T2.val) {
			res = assist(T1, T2);
		}
		if (!res) {
			return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
		}
		return res;
	}

	private static boolean assist(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		}
		if (t1 != null && t2 != null && t1.val == t2.val) {
			return assist(t1.left, t2.left) && assist(t1.right, t2.right);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode T1 = new TreeNode(1);
		T1.left = new TreeNode(2);
		T1.right = new TreeNode(3);
		T1.right.left = new TreeNode(4);
		TreeNode T2 = new TreeNode(3);
		T2.right = new TreeNode(4);
		System.out.println(isSubtree(T1, T2));
	}

}
