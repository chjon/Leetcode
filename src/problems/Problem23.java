package problems;

import dataStructures.ListNode;

/**
 * Solutions to "Merge k Sorted Lists"
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class Problem23 {

	// Initial solution ------------------------------------------------------------------------------------------------

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}

		// Find head node
		int minIndex = -1;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				if (minIndex == -1) {
					minIndex = i;
				} else if (lists[i].val < lists[minIndex].val) {
					minIndex = i;
				}
			}
		}

		if (minIndex == -1) {
			return null;
		}

		ListNode head = lists[minIndex];
		ListNode tail = head;
		lists[minIndex] = lists[minIndex].next;

		// Find next smallest node
		while (minIndex >= 0) {
			minIndex = -1;

			for (int i = 0; i < lists.length; i++) {
				if (lists[i] != null) {
					if (minIndex == -1) {
						minIndex = i;
					} else if (lists[i].val < lists[minIndex].val) {
						minIndex = i;
					}
				}
			}

			if (minIndex >= 0) {
				tail.next = lists[minIndex];
				tail = tail.next;
				lists[minIndex] = lists[minIndex].next;
			}
		}

		return head;
	}
}
