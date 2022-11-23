package programmers.lv0;

import java.util.Stack;

public class 컨트롤제트 {

	public int solution(String s) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		String[] nums = s.split(" ");
		for (String str : nums) {
			if (str.equals("Z")) {
				if (!str.isEmpty()) stack.pop();
			} else {
				stack.push(Integer.parseInt(str));
			}
		}
		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		return answer;
	}
}
