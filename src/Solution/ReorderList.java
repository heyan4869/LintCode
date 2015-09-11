package Solution;

public class ReorderList {
	public static void reorderList(ListNode head) {  
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		ListNode slow = head;
		ListNode fast = head;
		int s = 1;
		int f = 1;
		while (fast != null) {
			fast = fast.next;
			f++;
			if (fast != null) {
				fast = fast.next;
				f++;
				slow = slow.next;
				s++;
			}
		}
		slow.next = reverse(slow.next, f - s - 1);
		ListNode p1 = head;
		ListNode p2 = slow;
		while (p2.next != null) {
			ListNode p1next = p1.next;
			ListNode p2next = p2.next;
			ListNode p2nextnext;
			if (p2.next != null) {
				p2nextnext = p2.next.next;
			} else {
				p2nextnext = null;
				
			}
			p1.next = p2next;
			p2next.next = p1next;
			p2.next = p2nextnext;
			p1 = p1next;
		}
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		reorderList(head);
		while (head != null) {
			System.out.print(head.val + " - ");
			head = head.next;
		}
	}

}
