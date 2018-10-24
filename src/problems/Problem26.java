package problems;

/**
 * Solutions to "Remove Duplicates from Sorted Array"
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 */
public class Problem26 {

	// Initial solution

	public int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int length = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[length - 1]) {
				nums[length] = nums[i];
				length++;
			}
		}

		return length;
	}
}
