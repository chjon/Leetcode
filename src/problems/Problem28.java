package problems;

/**
 * Solutions to "Implement strStr()"
 * https://leetcode.com/problems/implement-strstr/description/
 */
public class Problem28 {

	// Initial solution ------------------------------------------------------------------------------------------------

	public int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		} else if (needle.length() > haystack.length()) {
			return -1;
		}

		// Preprocessing
		int[][] lookUp = new int[256][needle.length()];
		int[] lookUpIndex = new int[256];

		// Find the indices of where each letter occurs
		for (int i = 0; i < needle.length(); i++) {
			char curChar = needle.charAt(i);
			lookUp[curChar][lookUpIndex[curChar]] = i + 1;
			lookUpIndex[curChar]++;
		}

		// Searching
		int needleStartIndex = 0;
		int needleIndex = needle.length() - 1;

		while (needleStartIndex + needle.length() - 1 < haystack.length()) {
			// Find the last difference between the needle and the current part of the haystack
			while (needleIndex > -1 && haystack.charAt(needleStartIndex + needleIndex) == needle.charAt(needleIndex)) {
				needleIndex--;
			}

			// No difference: found the needle
			if (needleIndex == -1) {
				return needleStartIndex;
			}

			// Shift the needle if it is not in this part of the haystack
			char curChar = haystack.charAt(needleStartIndex + needleIndex);
			int index = lookUpIndex[curChar] - 1;

			// Find the last occurrence of the character before the needleIndex
			while (index >= 0 && lookUp[curChar][index] > needleIndex) {
				index--;
			}

			if (index < 0) { // Current letter is not in the needle
				needleStartIndex = needleStartIndex + needleIndex + 1;
			} else { // Current letter is in the needle
				needleStartIndex += (needleIndex - lookUp[curChar][index] + 1);
			}

			needleIndex = needle.length() - 1;
		}

		return -1;
	}
}
