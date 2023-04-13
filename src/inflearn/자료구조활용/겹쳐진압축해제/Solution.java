package inflearn.자료구조활용.겹쳐진압축해제;

import java.util.*;

public class Solution {
	public String solution(String s) {
		int N = s.length();
		Stack<String> stack = new Stack<>();
		for (char x : s.toCharArray()) {
			if (x != ')') {
				stack.push(x + "");
			} else {
				String tmp = "";
				while (!stack.isEmpty()) {
					String c = stack.pop();
					if (c.equals("(")) {
						StringBuilder num = new StringBuilder();
						while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
							num.insert(0, stack.pop());
						}
						StringBuilder res = new StringBuilder();
						int cnt = 1;
						if (!num.toString().equals(""))
							cnt = Integer.parseInt(num.toString());
						while (cnt-- > 0)
							res.append(tmp);
						stack.push(res.toString());
						break;
					}
					tmp = c + tmp;
				}
			}
		}
		StringBuilder answer = new StringBuilder();
		for (String x : stack)
			answer.append(x);
 		return answer.toString();
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution("3(a2(b))ef"));
		System.out.println(T.solution("2(ab)k3(bc)"));
		System.out.println(T.solution("2(ab3((cd)))"));
		System.out.println(T.solution("2(2(ab)3(2(ac)))"));
		System.out.println(T.solution("3(ab2(sg))"));
	}
}