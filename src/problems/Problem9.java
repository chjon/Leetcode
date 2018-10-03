package problems;

/**
 * Solutions to "Palindrome Number"
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class Problem9 {

	// Initial solution ------------------------------------------------------------------------------------------------

	/**
	 * Double-sided checking solution
	 * The idea is to check if x is a palindrome the same way strings are checked (look at both sides)
	 *
	 * @param x the value to check
	 * @return whether x is a palindrome
	 */
	public boolean isPalindrome1(int x) {
		// x cannot be a palindrome if it is negative
		if (x < 0) {
			return false;
		}

		int magnitude = 0;
		int copyOfX = x;
		int temp = 0;

		// Find the magnitude of x
		while (copyOfX > 0) {
			copyOfX /= 10;
			magnitude++;
		}

		// Check from both sides
		while (x > 0 && magnitude > 1) {
			if ((x % 10) != ((x / (int)Math.pow(10, magnitude - 1)) % 10)) {
				return false;
			}

			magnitude -= 2;
			x /= 10;
		}

		return true;
	}

	// Second solution -------------------------------------------------------------------------------------------------

	/**
	 * Reverse-comparison solution
	 * The idea is to copy the digits of x in reverse order and then check if x is equal to its reverse
	 *
	 * @param x the value to check
	 * @return whether x is a palindrome
	 */
	public boolean isPalindrome2(int x) {
		// x cannot be a palindrome if it is negative
		if (x < 0) return false;

		// Reverse x
		int reverse = 0;
		int init = x;
		while (x > 0) {
			reverse = reverse * 10 + x % 10;
			x /= 10;
		}

		// Check if the initial value of x is equal to the reverse
		return init == reverse;
	}
}
