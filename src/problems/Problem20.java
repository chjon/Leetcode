package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solutions to "Valid Parentheses"
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class Problem20 {

	// Initial solution ------------------------------------------------------------------------------------------------

	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			char curChar = s.charAt(i);

			if (curChar == '(' || curChar == '[' || curChar == '{') {
				stack.push(curChar);
			} else if (stack.isEmpty()) {
				return false;
			} else if (curChar == ')' && stack.peek() == '(') {
				stack.pop();
			} else if (curChar == ']' && stack.peek() == '[') {
				stack.pop();
			} else if (curChar == '}' && stack.peek() == '{') {
				stack.pop();
			} else {
				return false;
			}
		}

		return stack.isEmpty();
	}
}
