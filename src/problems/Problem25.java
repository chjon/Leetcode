package problems;

import dataStructures.ListNode;

/**
 * Solutions to "Reverse Nodes in k-Group"
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 */
public class Problem25 {

	// Initial solution ------------------------------------------------------------------------------------------------

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) return head;

		ListNode newHead = null;
		ListNode newTail = null;

		while (hasK(head, k)) {
			ListNode reverseHead = head;
			ListNode reverseTail = head;
			ListNode temp = head;

			//Reverse k nodes
			for (int i = 1; i < k; i++) {
				temp = reverseTail.next;
				reverseTail.next = temp.next;
				temp.next = reverseHead;
				reverseHead = temp;
			}

			//Add the reversed nodes to the new list
			if (newHead == null) {
				newHead = reverseHead;
				newTail = reverseTail;
			} else {
				newTail.next = reverseHead;
				newTail = reverseTail;
			}

			//Shift the head along
			head = reverseTail.next;
			reverseTail.next = null;
		}

		if (newHead == null) {
			return head;
		}

		newTail.next = head;
		return newHead;
	}

	//Determine whether the list is at least k nodes long
	private boolean hasK (ListNode head, int k) {
		int count = 0;
		while (head != null && count < k) {
			head = head.next;
			count++;
		}

		return count == k;
	}
}
