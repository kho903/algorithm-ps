package programmers.lv2;

import java.util.*;

public class 수식최대화 {

	static char[] op = {'*', '+', '-'};
	static boolean[] ch;
	static long answer;
	static ArrayList<Long> numbers;
	static ArrayList<Character> opers;

	public long solution(String expression) {
		answer = 0;
		numbers = new ArrayList<>();
		opers = new ArrayList<>();
		ch = new boolean[3];
		int N = expression.length();
		String num = "";
		for (int i = 0; i < N; i++) {
			char x = expression.charAt(i);
			if ('0' <= x && x <= '9') {
				num += x;
			} else {
				numbers.add(Long.parseLong(num));
				num = "";
				opers.add(x);
			}
		}
		numbers.add(Long.parseLong(num));
		dfs(0, new char[3]);

		return answer;
	}

	public void dfs(int count, char[] ops) {
		if (count == 3) {
			ArrayList<Long> numbersCopy = new ArrayList<>(numbers);
			ArrayList<Character> opsCopy = new ArrayList<>(opers);

			for (char oper : ops) {
				for (int i = 0; i < opsCopy.size(); i++) {
					if (oper == opsCopy.get(i)) {
						Long cur = calc(numbersCopy.remove(i), numbersCopy.remove(i), oper);
						numbersCopy.add(i, cur);
						opsCopy.remove(i);
						i--;
					}
				}
			}
			answer = Math.max(answer, Math.abs(numbersCopy.get(0)));
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (!ch[i]) {
				ch[i] = true;
				ops[count] = op[i];
				dfs(count + 1, ops);
				ch[i] = false;
			}
		}

	}

	public Long calc(Long a, Long b, char op) {
		Long num = 0L;
		switch (op) {
			case '*':
				num = a * b;
				break;
			case '+':
				num = a + b;
				break;
			case '-':
				num = a - b;
				break;
		}
		return num;
	}

}
