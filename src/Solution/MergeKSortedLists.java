package Solution;

import java.util.ArrayList;
import java.util.List;

public class MergeKSortedLists {
	public static ListNode mergeKLists(List<ListNode> lists) {  
		ListNode fakeHead = new ListNode(Integer.MAX_VALUE);
		ListNode backup = fakeHead;
		while (true) {
			int tempMin = Integer.MAX_VALUE;
			int tempIdx = -1;
			for (int i = 0; i < lists.size(); i++) {
				if (lists.get(i) != null && tempMin >= lists.get(i).val) {
					tempMin = lists.get(i).val;
					tempIdx = i;
				}
			}
			if (tempMin == Integer.MAX_VALUE && tempIdx == -1) {
				break;
			}
			backup.next = new ListNode(tempMin);
			backup = backup.next;
			ListNode tempNode = lists.get(tempIdx);
			tempNode = tempNode.next;
			lists.remove(tempIdx);
			lists.add(tempIdx, tempNode);
		}
		
		return fakeHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<ListNode> lists = new ArrayList<ListNode>();
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(-1);
		l1.next = new ListNode(5);
		lists.add(l1);
		lists.add(l2);
		lists.add(l3);
		ListNode res = mergeKLists(lists);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

}
