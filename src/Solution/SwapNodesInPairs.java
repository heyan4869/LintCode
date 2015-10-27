package Solution;

public class SwapNodesInPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode pointer = fake;
		while (pointer.next != null) {
			ListNode cur = pointer.next;
			if (cur.next == null) {
				break;
			}
			ListNode next = cur.next;
			cur.next = next.next;
			next.next = cur;
			pointer.next = next;
			pointer = cur;
		}
		
		return fake.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode res = swapPairs(head);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

}
