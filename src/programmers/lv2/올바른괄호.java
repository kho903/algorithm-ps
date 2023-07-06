package programmers.lv2;

import java.util.*;

public class 올바른괄호 {

	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (ch == '(') stack.push('(');
			else if (ch == ')') {
				if (stack.isEmpty()) return false;
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
