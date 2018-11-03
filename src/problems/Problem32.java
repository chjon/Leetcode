package problems;

/**
 * Solutions to "Longest Valid Parentheses"
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 */
public class Problem32 {

	// Initial solution ------------------------------------------------------------------------------------------------

	private enum State {
		OPEN_L,
		OPEN_R,
		CLOSED
	}

	public int longestValidParentheses(String s) {
		State[] states = new State[s.length()];
		for (int i = 0; i < s.length(); i++) {
			char curChar = s.charAt(i);
			if (curChar == '(') {
				states[i] = State.OPEN_L;
			} else {
				boolean closed = false;
				for (int j = i - 1; j >= 0; j -= 2) {
					if (states[j] == State.OPEN_L) {
						states[i] = State.CLOSED;
						states[j] = State.CLOSED;
						closed = true;
						break;
					} else if (states[j] == State.OPEN_R) {
						break;
					}
				}

				if (!closed) {
					states[i] = State.OPEN_R;
				}
			}
		}

		int max = 0;
		int count = 0;
		for (int i = 0; i < states.length; i++) {
			if (states[i] != State.CLOSED) {
				max = Math.max(max, count);
				count = 0;
			} else {
				count++;
			}
		}

		return Math.max(max, count);
	}

}
