package Solution;

public class PalindromeLinkedList {
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode fake = new ListNode(0);
		fake.next = head;
		ListNode fast = head;
		ListNode pointer = fake;
		ListNode slow = head;
		ListNode curr = head;
		ListNode next = curr.next;
		boolean even = false;
		while (fast.next != null) {
			if (fast.next.next == null) {
				even = true;
				fast = fast.next;
				break;
			}
			// no need to proceed slow
			// slow = slow.next;
			fast = fast.next.next;
			// reverse the first half of the list
			curr.next = next.next;
			next.next = fake.next;
			fake.next = next;
			next = curr.next;
		}
		if (!even) {
			pointer = pointer.next;
		}
		pointer = pointer.next;
		slow = slow.next;
		while (slow != null) {
			if (pointer.val != slow.val) {
				return false;
			}
			slow = slow.next;
			pointer = pointer.next;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		// head.next.next.next.next.next = new ListNode(1);
		boolean res = isPalindrome(head);
		System.out.println(res);
	}

}
