package Solution;

public class RemoveDuplicatesFromSortedListII {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
		ListNode backup = fakeHead;
		ListNode p1 = head;
		ListNode p2 = head.next;
		while (p2 != null) {
			if (p1.val != p2.val) {
				fakeHead.next = p1;
				fakeHead = fakeHead.next;
				p1 = p1.next;
				p2 = p2.next;
			} else {
				while (p2 != null && p1.val == p2.val) {
					p2 = p2.next;
				}
				p1 = p2;
				if (p2 != null) {
					p2 = p2.next;
				}
			}
		}
		fakeHead.next = p1;
		if (p1 != null) {
			p1.next = null;
		}
		return backup.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(4);
		ListNode res = deleteDuplicates(head);
		while (res != null) {
			System.out.print(res.val + " - ");
			res = res.next;
		}
	}

}
