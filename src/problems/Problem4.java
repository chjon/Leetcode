package problems;

/**
 * Solutions to "Median of Two Sorted Arrays"
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class Problem4 {

	// Initial solution ------------------------------------------------------------------------------------------------

	/**
	 * Array merge solution
	 * The idea is to merge the arrays together into one sorted array and then find the median of the sorted array
	 *
	 * @param nums1 The first sorted array
	 * @param nums2 The second sorted array
	 * @return The median of the values in the two arrays
	 */
	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int[] mergedArray = new int[nums1.length + nums2.length];
		int index1 = 0, index2 = 0;

		// Merge the arrays together in order

		// Handle the case where there are still numbers in both arrays
		while (index1 < nums1.length && index2 < nums2.length) {
			// Add number from the first array if smaller than the number in the second array
			if (nums1[index1] < nums2[index2]) {
				mergedArray[index1 + index2] = nums1[index1];
				index1++;
				// Add number from the second array if smaller than the number in the first array
			} else {
				mergedArray[index1 + index2] = nums2[index2];
				index2++;
			}
		}

		// Handle the case where only the first array has numbers
		while (index1 < nums1.length) {
			// Add number from the first array
			mergedArray[index1 + index2] = nums1[index1];
			index1++;
		}

		// Handle the case where only the second array has numbers
		while (index2 < nums2.length) {
			// Add number from the second array
			mergedArray[index1 + index2] = nums2[index2];
			index2++;
		}

		// Get the median value

		// Handle the case where the data set has an odd length
		if (mergedArray.length % 2 == 1) {
			return mergedArray[mergedArray.length / 2];

		// Handle the case where the data set has an even length
		} else {
			return (((double)mergedArray[mergedArray.length / 2]) + mergedArray[mergedArray.length / 2 - 1]) / 2;
		}
	}

	// Second solution -------------------------------------------------------------------------------------------------

	/**
	 * Counting solution
	 * The idea is to count through the first half of the elements and then return the middle
	 *
	 * @param nums1 The first sorted array
	 * @param nums2 The second sorted array
	 * @return The median of the values in the two arrays
	 */
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int remaining = nums1.length + nums2.length;
		int odd = remaining % 2;
		remaining /= 2;
		remaining += odd - 1;
		int index1 = 0, index2 = 0;

		// Count the first half of the elements
		while (remaining > 0) {
			// Check if the median must be in the second array
			if (index1 == nums1.length) {
				index2 += remaining;

				if (odd == 1) {
					return nums2[index2];
				} else {
					return (nums2[index2] + nums2[index2 + 1]) / 2.0;
				}

			// Check if the median must be in the first array
			} else if (index2 == nums2.length) {
				index1 += remaining;

				if (odd == 1) {
					return nums1[index1];
				} else {
					return (nums1[index1] + nums1[index1 + 1]) / 2.0;
				}

			// Increment the indices based on which array has a smaller value
			} else if (nums1[index1] < nums2[index2]) {
				index1++;
			} else {
				index2++;
			}

			remaining--;
		}

		// Get the number in the middle
		int sum = 0;
		if (index1 == nums1.length) {
			sum += nums2[index2++];
		} else if (index2 == nums2.length) {
			sum += nums1[index1++];
		} else if (nums1[index1] < nums2[index2]) {
			sum += nums1[index1++];
		} else {
			sum += nums2[index2++];
		}

		// Return the number in the middle if the total length is odd
		if (odd == 1) {
			return sum;
		}

		// Get the second number in the middle if the total length is even
		if (index1 == nums1.length) {
			sum += nums2[index2];
		} else if (index2 == nums2.length) {
			sum += nums1[index1];
		} else if (nums1[index1] < nums2[index2]) {
			sum += nums1[index1];
		} else {
			sum += nums2[index2];
		}

		// Return the average of the two values in the middle
		return sum / 2.0;
	}
}
