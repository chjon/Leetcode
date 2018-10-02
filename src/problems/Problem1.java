package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Solutions to "Two Sum"
 * https://leetcode.com/problems/two-sum/description/
 */
public class Problem1 {

	// Initial solution ------------------------------------------------------------------------------------------------

	/**
	 * Brute force solution
	 * The idea is to check every number against every other number
	 *
	 * @param nums   the list of numbers to check
	 * @param target the target sum
	 * @return an array containing the indices of the two values that sum to the target;
	 *         null if these indices do not exist
	 */
	public int[] twoSum1(int[] nums, int target) {
		// Compare every element to every other element
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {

				// Return the indices if the values sum to the target
				if (nums[i] + nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}

		return null;
	}

	// Second solution -------------------------------------------------------------------------------------------------

	/**
	 * Two-pointer solution
	 * The idea is to sort the array and then narrow down the results until the target value is found
	 *
	 * @param nums   the list of numbers to check
	 * @param target the target sum
	 * @return an array containing the indices of the two values that sum to the target;
	 *         null if these indices do not exist
	 */
	public int[] twoSum2(int[] nums, int target) {
		// Create a data structure to hold the numbers along with their indices
		int[][] numsIndices = new int[nums.length][2];
		for (int i = 0; i < nums.length; i++) {
			numsIndices[i][0] = nums[i];
			numsIndices[i][1] = i;
		}

		// Sort the array
		mergeSort(numsIndices, new int[nums.length][2], 0, nums.length - 1);

		// Use two pointers to narrow down two values that sum to the target
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int sum = numsIndices[left][0] + numsIndices[right][0];

			if (sum < target) {
				left++;
			} else if (sum > target) {
				right--;
			} else {
				return new int[] {numsIndices[left][1], numsIndices[right][1]};
			}
		}

		return null;
	}

	/**
	 * Helper method for twoSum2
	 * Sort the array while maintaining index data
	 *
	 * @param nums      the array to sort
	 * @param workArray an array for storing intermediate sorted data
	 * @param lo        the index of the beginning of the range to be sorted
	 * @param hi        the index of the end of the range to be sorted
	 */
	private void mergeSort (int[][] nums, int[][] workArray, int lo, int hi) {
		// Return if the array is trivially sorted (length of 1)
		if (lo == hi) return;

		// Sort the sub-arrays
		int mid = (lo + hi) / 2;
		mergeSort(nums, workArray, lo, mid);
		mergeSort(nums, workArray, mid + 1, hi);

		// Merge two sorted lists
		int indexA = lo, indexB = mid + 1, index = lo;
		while (index <= hi) {
			// Handle the case where the first array is empty
			if (indexA > mid) {
				workArray[index++] = nums[indexB++];

			// Handle the case where the second array is empty
			} else if (indexB > hi) {
				workArray[index++] = nums[indexA++];

			// Pick the smaller value from the two arrays
			} else if (nums[indexA][0] < nums[indexB][0]) {
				workArray[index++] = nums[indexA++];
			} else {
				workArray[index++] = nums[indexB++];
			}
		}

		// Copy the sorted list back into nums
		for (int i = lo; i <= hi; i++) {
			nums[i] = workArray[i];
		}
	}

	// Third solution --------------------------------------------------------------------------------------------------

	/**
	 * HashMap solution
	 * The idea is to keep track of all the numbers that have been seen before and to check if a number's
	 * complement (i.e., the other number needed to sum to the target) has been found
	 *
	 * @param nums   the list of numbers to check
	 * @param target the target sum
	 * @return an array containing the indices of the two values that sum to the target;
	 *         null if these indices do not exist
	 */
	public int[] twoSum(int[] nums, int target) {
		// A map from values to indices
		Map<Integer, Integer> indexMap = new HashMap<>();

		// Check each value to see if its counterpart has been found
		for (int i = 0; i < nums.length; i++) {
			if (indexMap.containsKey(target - nums[i])) {
				return new int[] {i, indexMap.get(target - nums[i])};
			}

			indexMap.put(nums[i], i);
		}

		// Return invalid output if the numbers are not found
		return new int[] {-1, -1};
	}
}
