package problems;

/**
 * Solutions to "Integer to Roman"
 * https://leetcode.com/problems/integer-to-roman/description/
 */
public class Problem12 {

	// Initial solution ------------------------------------------------------------------------------------------------

	private static final String[] sym = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	private static final int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

	/**
	 * Parallel array solution
	 * The idea is to gradually truncate the value, using an array as a map
	 *
	 * @param num the number to convert to Roman numerals
	 * @return the Roman numeral representation of the input value
	 */
	public String intToRoman1(int num) {
		StringBuilder roman = new StringBuilder();

		// Iterate through each possible symbol
		for (int i = 0; i < sym.length; i++) {
			// Repeat a symbol if needed
			while (num >= val[i]) {
				roman.append(sym[i]);
				num -= val[i];
			}
		}

		return roman.toString();
	}

	/**
	 * Slightly optimized version of solution 1 using only one loop
	 *
	 * @param num the number to convert to Roman numerals
	 * @return the Roman numeral representation of the input value
	 */
	public String intToRoman2(int num) {
		StringBuilder roman = new StringBuilder();

		// Iterate through each possible symbol, repeating if needed
		int i = 0;
		while (i < sym.length) {
			if (num >= val[i]) {
				roman.append(sym[i]);
				num -= val[i];
			} else {
				i++;
			}
		}

		return roman.toString();
	}
}
