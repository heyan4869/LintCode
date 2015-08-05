package Solution;

public class AddTwoNumbers {
	public static ListNode addLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode res = new ListNode(0);
		ListNode p = res;
		int carry = 0;
		while (p1 != null && p2 != null) {
			int temp = p1.val + p2.val + carry;
			p.next = new ListNode(temp % 10);
			carry = temp / 10;
			p = p.next;
			p1 = p1.next;
			p2 = p2.next;
		}
		while (p1 != null) {
			int temp = p1.val + carry;
			p.next = new ListNode(temp % 10);
			carry = temp / 10;
			p = p.next;
			p1 = p1.next;
		}
		while (p2 != null) {
			int temp = p2.val + carry;
			p.next = new ListNode(temp % 10);
			carry = temp / 10;
			p = p.next;
			p2 = p2.next;
		}
		if (carry != 0) {
			p.next = new ListNode(carry);
		}
		
		return res.next;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(6);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(2);
		ListNode res = addLists(l1, l2);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

}
