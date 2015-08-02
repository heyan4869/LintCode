package Solution;

public class RemoveDuplicatesFromSortedList {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p1 = head;
		ListNode p2 = head.next;
		while (p1 != null && p2 != null) {
			if (p2.val != p1.val) {
				p1.next = p2;
				p1 = p1.next;
				p2 = p2.next;
			} else {
				p2 = p2.next;
			}
		}
		if (p2 == null) {
			p1.next = null;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		ListNode res = deleteDuplicates(head);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
