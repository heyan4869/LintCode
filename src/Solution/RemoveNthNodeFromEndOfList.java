package Solution;

public class RemoveNthNodeFromEndOfList {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode p1 = fakeHead;
		ListNode p2 = fakeHead;
		while (p2 != null && n != 0) {
			p2 = p2.next;
			n--;
		}
		if (p2 == null) {
			return head;
		}
		while (p1.next != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		p1.next = p1.next.next;
		return fakeHead.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode res = removeNthFromEnd(head, 2);
		while (res != null) {
			System.out.print(" - " + res.val + " - ");
			res = res.next;
		}
	}

}
