package Solution;

public class RotateList {
	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k < 0) {
			return head;
		}
		ListNode backup = head;
		int len = getLen(backup);
		ListNode p1 = head;
		ListNode p2 = head;
		int step = k % len;
		if (step == 0) {
			return head;
		}
		while (step != 0) {
			p2 = p2.next;
			step--;
		}
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		ListNode res = p1.next;
		p2.next = head;
		p1.next = null;
		return res;
	}
	
	private static int getLen(ListNode head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			len++;
		}
		return len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode res = rotateRight(head, 4);
		while (res != null) {
			System.out.print(res.val + " - ");
			res = res.next;
		}
	}

}
