package Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreeZigzagLevelOrder {
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return res;
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Set<Integer> hs = new HashSet<Integer>();
		assist(root, 1, hs, temp, res);
		return res;
	}

	private static void assist(TreeNode root, int level, Set<Integer> hs,
			List<Integer> temp, ArrayList<ArrayList<Integer>> res) {
		if (root == null) {
			return;
		}
		if (!hs.contains(level)) {
			hs.add(level);
			ArrayList<Integer> cur = new ArrayList<Integer>();
			res.add(cur);
			res.get(level - 1).add(root.val);
		} else {
			// deal with the direction by adding to different index
			if (level % 2 == 1) {
				res.get(level - 1).add(root.val);
			} else {
				res.get(level - 1).add(0, root.val);
			}
		}
		assist(root.left, level + 1, hs, temp, res);
		assist(root.right, level + 1, hs, temp, res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		ArrayList<ArrayList<Integer>> result = zigzagLevelOrder(root);
		// System.out.println(root.right.val);
		System.out.println(result);

	}

}
