package problems;

/**
 * Solutions to "ZigZag Conversion"
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
public class Problem6 {

	// Initial solution ------------------------------------------------------------------------------------------------

	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		int cycleLength = 2 * numRows - 2;
		StringBuilder output = new StringBuilder();

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; i + j * cycleLength < s.length(); j++) {
				output.append(s.charAt(j * cycleLength + i));

				if (i > 0 && i < numRows - 1 && (j + 1) * cycleLength - i < s.length()) {
					output.append(s.charAt(i + (j + 1) * cycleLength - 2 * i));
				}
			}
		}

		return output.toString();
	}
}
