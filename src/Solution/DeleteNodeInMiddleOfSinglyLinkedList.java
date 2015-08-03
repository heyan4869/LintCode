package Solution;

public class DeleteNodeInMiddleOfSinglyLinkedList {
	public static void deleteNode(ListNode node) {
		ListNode p = node.next;
		while (p != null) {
			node.val = p.val;
			p = p.next;
			if (p != null) {
				node = node.next;
			} else {
				node.next = null;
			}
		}
		return;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		deleteNode(l1.next.next);
		while (l1 != null) {
			System.out.print(" - " + l1.val + " - ");
			l1 = l1.next;
		}
	}

}
