package Solution;

public class LinkedListCycleII {
	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		while (p1 != null && p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				break;
			}
		}
		// check if no cycle exists
		if (p2 == null || p2.next == null) {
			return null;
		}
		// let p1 start from head, and meet p2 at the start of cycle
		p1 = head;
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
