package Solution;

public class PartitionLinkedList {
	public static ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p1 = new ListNode(0);
		ListNode backup1 = p1;
		p1.next = head;
		ListNode p2 = new ListNode(0);
		ListNode backup2 = p2;
		while (p1.next != null) {
			if (p1.next.val < x) {
				p2.next = p1.next;
				p2 = p2.next;
				if (p1.next.next == null) {
					p1.next = null;
				} else {
					p1.next = p1.next.next;
					// p1.next could be less than x, need to check
					// p1 = p1.next;
				}
			} else {
				p1 = p1.next;
			}
		}
		p2.next = backup1.next;
		return backup2.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(3);
		head.next = new ListNode(3);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(4);
		//head.next.next.next.next.next = new ListNode(2);
		ListNode res = partition(head, 3);
		while (res != null) {
			System.out.print(" - " + res.val + " - ");
			res = res.next;
		}
	}

}
