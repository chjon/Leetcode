package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Solutions to "Letter Combinations of a Phone Number"
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class Problem17 {

	// Initial solution ------------------------------------------------------------------------------------------------

	private static final char[][] map = {
			{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
			{'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
			{'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
	};

	private ArrayList<String> append(char prefix, ArrayList list) {
		ArrayList<String> newList = new ArrayList();

		if (list.isEmpty()) {
			newList.add("" + prefix);
			return newList;
		}

		for (Object s : list) {
			newList.add(prefix + (String)s);
		}

		return newList;
	}

	public List<String> letterCombinations(String digits) {
		ArrayList<String> combinations = new ArrayList();

		if (!digits.isEmpty()) {
			ArrayList otherCombinations = (ArrayList)letterCombinations(digits.substring(1));
			int currentDigit = digits.charAt(0) - '0';

			for (int i = 0; i < map[currentDigit].length; i++) {
				combinations.addAll(append(map[currentDigit][i], otherCombinations));
			}
		}

		return combinations;
	}
}
