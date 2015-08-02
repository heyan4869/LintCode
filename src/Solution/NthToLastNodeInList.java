package Solution;

public class NthToLastNodeInList {
	public static ListNode nthToLast(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		int len = getLen(head);
		int num = len - n;
		while (num != 0) {
			head = head.next;
			num--;
		}
		return head;
	}

	private static int getLen(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		System.out.println(nthToLast(head, 4).val);
	}

}
