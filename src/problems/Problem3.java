package problems;

/**
 * Solutions to "Longest Substring without repeating characters"
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Problem3 {

	// Initial solution ------------------------------------------------------------------------------------------------

	/**
	 * Brute force solution
	 * The idea is to get the length of the longest substring starting at each index without repeating characters
	 *
	 * @param s the string to check
	 * @return the length of the longest substring that does not contain any duplicate characters
	 */
	public int lengthOfLongestSubstring (String s) {
		int longest = 0;
		boolean[] found = new boolean[256];

		// Iterate through each character
		for (int i = 0; i < s.length(); i++) {
			int currentLength = 0;
			char curChar;

			// Iterate through each of the following characters
			for (int j = i; j < s.length(); j++) {
				curChar = s.charAt(j);

				// Check whether character has previously appeared
				if (found[curChar]) {
					break;
				} else {
					found[curChar] = true;
					currentLength++;
				}
			}

			// Clear boolean array
			for (int j = 0; j < found.length; j++) {
				found[j] = false;
			}

			// Check whether the substring is longer than the previous maximum
			longest = Math.max(longest, currentLength);
		}

		return longest;
	}

	// Second solution -------------------------------------------------------------------------------------------------

	/**
	 * This is a slight optimization to the first solution, where we can skip groups of characters if we know that they
	 * contain duplicates
	 *
	 * @param s the string to check
	 * @return the length of the longest substring that does not contain any duplicate characters
	 */
	public int lengthOfLongestSubstring2 (String s) {
		int[] foundIndex = new int[256];
		for (int i = 0; i < foundIndex.length; i++) {
			foundIndex[i] = -1;
		}

		int startIndex = 0;
		int endIndex = 0;
		int longest = 0;
		while (startIndex < s.length() && endIndex < s.length()) {
			char curChar = s.charAt(endIndex);
			if (foundIndex[curChar] == -1) {
				foundIndex[curChar] = endIndex;
				endIndex++;
			} else {
				longest = Math.max(longest, endIndex - startIndex);
				startIndex = foundIndex[curChar];
				endIndex = startIndex + 1;

				for (int i = 0; i < foundIndex.length; i++) {
					foundIndex[i] = -1;
				}
			}
		}

		return Math.max(longest, endIndex - startIndex);
	}

	// Third solution --------------------------------------------------------------------------------------------------

	/**
	 * Sliding window approach
	 * The idea is to grow a sub-array to the right while the window doesn't contain any duplicates, and to shrink the
	 * sub-array from the left while it contains duplicates
	 *
	 * @param s the string to check
	 * @return the length of the longest substring that does not contain any duplicate characters
	 */
	public int lengthOfLongestSubstring3 (String s) {
		// Keep track of the characters in the subset
		boolean[] found = new boolean[256];
		int longest = 0;
		int left = 0, right = 0;

		// Iterate through the string
		while (left < s.length() && right < s.length()) {
			// Shrink the sub-array from the left if the character is already in the sub-array
			if (found[s.charAt(right)]) {
				found[s.charAt(left++)] = false;

			// Grow the sub-array to the right if the character is not yet in the sub-array
			} else {
				found[s.charAt(right++)] = true;
				longest = Math.max(longest, right - left);
			}
		}

		return longest;
	}
}
