package problems;

import dataStructures.ListNode;

/**
 * Solutions to "Remove Nth Node From End of List"
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 */
public class Problem19 {

	// Initial solution ------------------------------------------------------------------------------------------------

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode left = head;
		ListNode right = head;

		for (int i = 0; i < n; i++) {
			right = right.next;
		}

		if (right == null) {
			return head.next;
		}

		while (right.next != null) {
			left = left.next;
			right = right.next;
		}

		left.next = left.next.next;
		return head;
	}
}
