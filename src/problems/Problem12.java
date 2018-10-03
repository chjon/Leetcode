package problems;

/**
 * Solutions to "Integer to Roman"
 * https://leetcode.com/problems/integer-to-roman/description/
 */
public class Problem12 {

	// Initial solution ------------------------------------------------------------------------------------------------

	private static final String[] sym = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	private static final int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

	public String intToRoman(int num) {
		StringBuilder roman = new StringBuilder();

		for (int i = 0; i < sym.length; i++) {
			while (num >= val[i]) {
				roman.append(sym[i]);
				num -= val[i];
			}
		}

		return roman.toString();
	}
}
