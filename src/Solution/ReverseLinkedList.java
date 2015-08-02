package Solution;

public class ReverseLinkedList {
	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode temp = new ListNode(head.val);
		return assist(temp, head);
	}

	private static ListNode assist(ListNode temp, ListNode curr) {
		if (curr.next == null) {
			return temp;
		}
		ListNode backup = new ListNode(curr.next.val);
		backup.next = temp;
		curr = curr.next;
		return assist(backup, curr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode res = reverse(head);
		while (res != null) {
			System.out.print(" - " + res.val + " - ");
			res = res.next;
		}
	}

}
