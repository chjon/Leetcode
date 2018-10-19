package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Solutions to "Generate Parentheses"
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class Problem22 {

	// Initial solution ------------------------------------------------------------------------------------------------

	private static List<String>[] allLists;

	private static List<String> append (String prefix, List<String> list, String postfix) {
		List<String> newList = new ArrayList<>();

		for (String s : list) {
			String newString = prefix + s + postfix;

			newList.add(newString);
		}

		return newList;
	}

	private static void addUnique (List<String> target, List<String> source) {
		for (String s : source) {
			if (!target.contains(s)) {
				target.add(s);
			}
		}
	}

	private static List<String> permuteUnique (List<String> l1, List<String> l2) {
		List<String> newList = new ArrayList<>();

		for (String s1 : l1) {
			for (String s2 : l2) {
				newList.add(s1 + s2);
			}
		}

		for (String s2 : l2) {
			for (String s1 : l1) {
				String newString = s2 + s1;

				if (!newList.contains(newString)) {
					newList.add(newString);
				}
			}
		}

		return newList;
	}

	public List<String> generateParenthesis(int n) {
		allLists = new List[Math.max(2, n + 1)];

		allLists[0] = new ArrayList<>();
		allLists[1] = new ArrayList<>();
		allLists[1].add("()");

		if (n == 0) {
			return allLists[0];
		} else if (n == 1) {
			return allLists[1];
		}

		int current = 2;

		while (current <= n) {
			allLists[current] = new ArrayList<>();

			for (int i = 1; i < current; i++) {
				addUnique(allLists[current], (permuteUnique(allLists[i], allLists[current - i])));
			}

			allLists[current].addAll(append("(", allLists[current - 1], ")"));

			current++;
		}

		return allLists[n];
	}
}
