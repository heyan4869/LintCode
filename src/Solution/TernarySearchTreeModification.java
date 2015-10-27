package Solution;

import java.util.ArrayList;

public class TernarySearchTreeModification {

	private class Node {
		private int val;
		private Node left = null;
		private Node right = null;
		private Node mid = null;

		public Node(int val) {
			this.val = val;
		}
	}

	private Node root;

	public void insert(int val) {
        Node candidate = new Node(val);
        if (root == null) {
            root = candidate;
            return;
        }
        Node cur = root;
        Node pre = null;
        while (cur != null) {
            pre = cur;
            if (cur.val < val) {
                cur = cur.right;
            } else if (cur.val > val) {
                cur = cur.left;
            } else {
                cur = cur.mid;
            }
        }
        if (pre.val < val) {
            pre.right = candidate;
        } else if (pre.val > val) {
            pre.left = candidate;
        } else {
            pre.mid = candidate;
        }
    }


	public void delete(int val) {
        if (root == null) {
            return;
        }
        Node cur = root;
        Node pre = null;
        // find the delete position
        while (cur != null) {
            if (cur.val < val) {
                pre = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                pre = cur;
                cur = cur.left;
            } else {
                break;
            }
        }
        if (cur == null) {
            return;
        }
        // check if there are several nodes have value val
        if (cur.mid != null) {
            while (cur.mid != null) {
                pre = cur;
                cur = cur.mid;
            }
            pre.mid = null;
            return;
        }
        // if the target node has no child
        if (cur.left == null && cur.right == null) {
            if (cur == root) {
                root = null;
            } else if (cur == pre.left) {
                pre.left = null;
            } else {
                pre.right = null;
            }
            return;
        }
        // if the target node has one child
        if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            } else if (cur == pre.left) {
                pre.left = cur.left;
            } else {
                pre.right = cur.left;
            }
        } else if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            } else if (cur == pre.left) {
                pre.left = cur.right;
            } else {
                pre.right = cur.right;
            }
        } else {
            // if the target node has both child
            Node leftMax = cur.left;
            Node par = null;
            while (leftMax.right != null) {
                par = leftMax;
                leftMax = leftMax.right;
            }
            if (par != null) {
                par.right = null;
                cur.val = leftMax.val;
            } else {
                cur.val = leftMax.val;
                cur.left = null;
            }
        }
        return;
    }

	@Override
	public String toString() {
		String res = "";
		ArrayList<Integer> al = new ArrayList<>();
		helper(root, al);
		for (int i = 0; i < al.size(); i++) {
			res += al.get(i) + "";
		}
		return res;
	}
	
	private void helper(Node cur, ArrayList<Integer> al) {
		if (cur != null) {
			al.add(cur.val);
		}
		if (cur.left != null) {
			helper(cur.left, al);
		}
		if (cur.right != null) {
			helper(cur.right, al);
		}
	}
}
