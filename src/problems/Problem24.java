package problems;

import dataStructures.ListNode;

/**
 * Solutions to "Swap Nodes in Pairs"
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class Problem24 {

	// Initial solution ------------------------------------------------------------------------------------------------

	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		}

		ListNode tail = head;

		ListNode nodeA = head;
		ListNode nodeB = head.next;
		ListNode nodeC = head.next.next;

		nodeB.next = nodeA;
		nodeA.next = nodeC;
		head = nodeB;
		tail = nodeA;

		while (tail.next != null && tail.next.next != null) {
			nodeA = tail.next;
			nodeB = tail.next.next;
			nodeC = tail.next.next.next;

			nodeB.next = nodeA;
			nodeA.next = nodeC;
			tail.next = nodeB;
			tail = nodeA;
		}

		return head;
	}
}
