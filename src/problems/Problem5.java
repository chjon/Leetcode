package problems;

/**
 * Solutions to "Longest Palindromic Substring"
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class Problem5 {

	// Initial solution ------------------------------------------------------------------------------------------------

	/**
	 * Brute-force solution
	 * The idea is to check the length of every palindrome centred at each index
	 *
	 * @param s the string for which to find the longest palindrome
	 * @return the longest palindromic substring of s
	 */
	public String longestPalindrome(String s) {
		String longest = "";

		// Get first character
		if (s.length() > 0) {
			longest += s.charAt(0);
		}

		for (int i = 0; i < s.length() - 1; i++) {
			// Check for odd-length palindrome
			if (i < s.length() - 2 &&
					s.charAt(i) == s.charAt(i + 2)) {

				boolean foundPalindromeEnd = false;
				int j = 1;

				// Check letters to the side
				while (!foundPalindromeEnd) {
					//Check for the beginning/end of the string
					if (i - j < 0 || i + 2 + j >= s.length()) {
						foundPalindromeEnd = true;
						// Check for a palindrome
					} else if (s.charAt(i - j) == s.charAt(i + 2 + j)) {
						j++;
						// Handle the end of the palindrome
					} else {
						foundPalindromeEnd = true;
					}
				}

				// Check whether newly found palindrome is longer
				if (longest.length() < 2 * j + 1) {
					longest = s.substring(i - j + 1, i + 2 + j);
				}
			}

			// Check for even-length palindrome
			if (s.charAt(i) == s.charAt(i + 1)) {

				boolean foundPalindromeEnd = false;
				int j = 1;

				// Check letters to the side
				while (!foundPalindromeEnd) {
					// Check for the beginning/end of the string
					if (i - j < 0 || i + 1 + j >= s.length()) {
						foundPalindromeEnd = true;
						// Check for a palindrome
					} else if (s.charAt(i - j) == s.charAt(i + 1 + j)) {
						j++;
						// Handle the end of the palindrome
					} else {
						foundPalindromeEnd = true;
					}
				}

				// Check whether newly found palindrome is longer
				if (longest.length() < 2 * j) {
					longest = s.substring(i - j + 1, i + 1 + j);
				}
			}
		}

		return longest;
	}
}
