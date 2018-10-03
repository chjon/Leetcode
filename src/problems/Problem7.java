package problems;

/**
 * Solutions to "Reverse Integer"
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class Problem7 {

	// Initial solution ------------------------------------------------------------------------------------------------

	/**
	 * Integer-only solution
	 * The idea is to reverse the value normally, but to check for overflows at each step
	 *
	 * @param x the value to reverse
	 * @return the reversed value of x
	 */
	public int reverse1(int x) {
		int reversedX = 0;
		int temp;

		while (x != 0) {
			temp = reversedX * 10 + x % 10;

			// Check for overflow
			if (temp / 10 != reversedX) {
				return 0;
			} else {
				reversedX = temp;
			}

			x /= 10;
		}

		return reversedX;
	}

	// Second solution -------------------------------------------------------------------------------------------------

	/**
	 * Larger data-type solution
	 * The idea is to reverse the value normally in a long, so that overflows can be checked at the end
	 *
	 * @param x the value to reverse
	 * @return the reversed value of x
	 */
	public int reverse2(int x) {
		long rev = 0;

		while (x != 0) {
			rev = rev * 10 + x % 10;
			x /= 10;
		}

		if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
			return 0;
		} else {
			return (int) rev;
		}
	}
}
