package problems;

/**
 * Solutions to "String to Integer (atoi)"
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class Problem8 {

	// Initial solution ------------------------------------------------------------------------------------------------

	public int myAtoi(String str) {
		str = str.trim();

		if (str.isEmpty()) {
			return 0;
		}

		int sign = 1;
		int val = 0;
		int temp;
		char curChar = str.charAt(0);

		if (curChar == '-') {
			sign = -1;
		} else if (curChar == '+') {
			sign = 1;
		} else if (curChar >= '0' && curChar <= '9') {
			val = (curChar - '0');
		} else {
			return 0;
		}

		for (int i = 1; i < str.length(); i++) {
			curChar = str.charAt(i);

			if (curChar < '0' || curChar > '9') {
				break;
			}

			temp = val * 10 + (str.charAt(i) - '0');

			if (temp / 10 == val) {
				val = temp;
			} else {
				return (sign > 0) ? (2147483647) : (-2147483648);
			}
		}

		val *= sign;

		return val;
	}
}
