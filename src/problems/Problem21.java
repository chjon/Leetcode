package problems;

import dataStructures.ListNode;

/**
 * Solutions to "Merge Two Sorted Lists"
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 */
public class Problem21 {

	// Initial solution ------------------------------------------------------------------------------------------------

	/**
	 * Linear solution
	 * The idea is to find the head first and then to merge the two lists
	 *
	 * @param l1 the first list to merge
	 * @param l2 the second list to merge
	 * @return the merged list
	 */
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		// Check if either of the lists are empty
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		// Find the initial head node
		ListNode head;
		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}

		// Merge the nodes
		ListNode tail = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}

			tail = tail.next;
		}

		// Make sure the list is complete
		if (l1 == null) {
			tail.next = l2;
		} else {
			tail.next = l1;
		}

		return head;
	}

	// Second solution -------------------------------------------------------------------------------------------------

	/**
	 * Optimized version of the first solution
	 * The idea is to use a dummy head node and then merge all at once
	 *
	 * @param l1 the first list to merge
	 * @param l2 the second list to merge
	 * @return the merged list
	 */
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		// Check if either of the lists are empty
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		// Create the dummy head node
		ListNode dummyHead = new ListNode(0);
		ListNode tail = dummyHead;

		// Merge the lists
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				tail.next = l2;
				l2 = null;
			} else if (l2 == null) {
				tail.next = l1;
				l1 = null;
			} else if (l1.val < l2.val) {
				tail.next = l1;
				tail = tail.next;
				l1 = l1.next;
			} else {
				tail.next = l2;
				tail = tail.next;
				l2 = l2.next;
			}
		}

		return dummyHead.next;
	}
}
