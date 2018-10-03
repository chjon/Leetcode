package problems;

/**
 * Solutions to "Longest Common Prefix"
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class Problem14 {

	// Initial solution ------------------------------------------------------------------------------------------------

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}

		String prefix = strs[0];

		for (int i = 1; i < strs.length && prefix.length() > 0; i++) {
			int numCommon = 0;

			while (numCommon < prefix.length() && numCommon < strs[i].length() && prefix.charAt(numCommon) == strs[i].charAt(numCommon)) {
				numCommon++;
			}

			if (numCommon == 0) {
				return "";
			}

			prefix = prefix.substring(0, numCommon);
		}

		return prefix;
	}
}
