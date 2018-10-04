package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Solutions to "Integer to Roman"
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class Problem13 {

	// Initial solution ------------------------------------------------------------------------------------------------

	private static final String sym = "IVXLCDM";
	private static final int[] val = {1, 5, 10, 50, 100, 500, 1000};

	/**
	 * String-map solution
	 * The idea is to use a string to map characters to values
	 *
	 * @param s the Roman numeral to convert to an integer
	 * @return the value of the Roman numeral
	 */
	public int romanToInt1(String s) {
		int result = 0;
		int last = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			// Find the value of each character
			int num = val[sym.indexOf(s.charAt(i))];

			if (num < last) {
				result -= num;
			} else {
				result += num;
			}

			last = num;
		}

		return result;
	}

	/**
	 * Map solution
	 * The idea is to use a hash map to map characters to values
	 *
	 * @param s the Roman numeral to convert to an integer
	 * @return the value of the Roman numeral
	 */
	public int romanToInt2(String s) {
		// Define the map and its initial values
		Map<Character, Integer> val = new HashMap<>();
		val.put('I', 1);
		val.put('V', 5);
		val.put('X', 10);
		val.put('L', 50);
		val.put('C', 100);
		val.put('D', 500);
		val.put('M', 1000);

		int result = 0;
		int last = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			// Find the value of each character
			int num = val.get(s.charAt(i));

			if (num < last) {
				result -= num;
			} else {
				result += num;
			}

			last = num;
		}

		return result;
	}
}
