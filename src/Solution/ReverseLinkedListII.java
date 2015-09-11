// tricky

package Solution;

public class ReverseLinkedListII {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		for (int i = 1; i < m; i++) {
			p = p.next;
		}
		p.next = reverse(p.next, n - m + 1);
		return dummy.next;
	}

	private static ListNode reverse(ListNode head, int n) {
		ListNode node = head, prev = null, next = null;
		for (int i = 0; i < n; i++) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}
		head.next = node;
		return prev;
	}

	public static void main(String args[]) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode res = reverseBetween(head, 2, 4);
		while (res != null) {
			System.out.print(res.val + " - ");
			res = res.next;
		}
	}
}
