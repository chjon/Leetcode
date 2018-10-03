package problems;

/**
 * Solutions to "Integer to Roman"
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class Problem13 {

	// Initial solution ------------------------------------------------------------------------------------------------

	private static final String sym = "IVXLCDM";
	private static final int[] val = {1, 5, 10, 50, 100, 500, 1000};

	public int romanToInt(String s) {
		int result = 0;
		int last = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
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
}
