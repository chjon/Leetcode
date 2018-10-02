package problems;

import dataStructures.ListNode;

/**
 * Solutions to "Add Two Numbers"
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class Problem2 {

	// Initial solution ------------------------------------------------------------------------------------------------

	/**
	 * Simple solution
	 * The idea is to add and carry the same way addition is done by hand
	 *
	 * @param l1 The list representing the first number
	 * @param l2 The list representing the second number
	 * @return A list representing the sum
	 */
	public ListNode addTwoNumbers1 (ListNode l1, ListNode l2) {
		// Create start of list
		ListNode headNode = null;
		ListNode curNode = headNode;
		ListNode newNode;

		int carry = 0;

		// Handle case where both nodes are valid
		while (l1 != null && l2 != null) {
			// Get sum and carry
			newNode = new ListNode(l1.val + l2.val + carry);
			carry = newNode.val / 10;
			newNode.val %= 10;

			// Generate head of list
			if (curNode == null) {
				headNode = newNode;
				curNode = headNode;

			// Append node to list
			} else {
				curNode.next = newNode;
				curNode = newNode;
			}

			// Move to next digit
			l1 = l1.next;
			l2 = l2.next;
		}

		// Handle case where l1 is valid
		while (l1 != null) {
			// Get sum and carry
			newNode = new ListNode(l1.val + carry);
			carry = newNode.val / 10;
			newNode.val %= 10;

			// Generate head of list
			if (curNode == null) {
				headNode = newNode;
				curNode = headNode;

			// Append node to list
			} else {
				curNode.next = newNode;
				curNode = newNode;
			}

			// Move to next digit
			l1 = l1.next;
		}

		// Handle case where l2 is valid
		while (l2 != null) {
			// Get sum and carry
			newNode = new ListNode(l2.val + carry);
			carry = newNode.val / 10;
			newNode.val %= 10;

			// Generate head of list
			if (curNode == null) {
				headNode = newNode;
				curNode = headNode;

			// Append node to list
			} else {
				curNode.next = newNode;
				curNode = newNode;
			}

			// Move to next digit
			l2 = l2.next;
		}

		// Handle residual carry
		if (carry > 0) {
			// Create new node
			newNode = new ListNode(carry);
			newNode.next = null;

			// Append node to list
			curNode.next = newNode;
			curNode = newNode;
		}

		return headNode;
	}

	// Second solution -------------------------------------------------------------------------------------------------

	/**
	 * Cleaned up version of solution 1
	 * The idea is to add and carry the same way addition is done by hand
	 *
	 * @param l1 The list representing the first number
	 * @param l2 The list representing the second number
	 * @return A list representing the sum
	 */
	public ListNode addTwoNumbers2 (ListNode l1, ListNode l2) {
		// Create a dummy head node to avoid having to handle special cases
		ListNode head = new ListNode(0);
		ListNode tail = head;

		// Keep adding while there are elements to add
		int carry = 0;
		while (l1 != null || l2 != null) {
			// Add l1 if it exists
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}

			// Add l2 if it exists
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}

			// Create a node for the digit
			tail.next = new ListNode(carry % 10);

			// Update the carry and the tail node
			carry /= 10;
			tail = tail.next;
		}

		// Add an extra node if there is a carry at the end
		if (carry == 1) {
			tail.next = new ListNode(1);
		}

		// Return the node pointed to by the dummy head node
		return head.next;
	}
}
