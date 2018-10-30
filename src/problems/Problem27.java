package problems;

/**
 * Solutions to "Remove Element"
 * https://leetcode.com/problems/remove-element/description/
 */
public class Problem27 {

	// Initial solution ------------------------------------------------------------------------------------------------

	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int length = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[length] = nums[i];
				length++;
			}
		}

		return length;
	}
}
