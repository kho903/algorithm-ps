package boj.string._4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String str = br.readLine();
			if (str.equals(".")) break;
			Stack<Character> stack = new Stack<>();
			boolean over = false;
			for (char c : str.toCharArray()) {
				if (isOpen(c)) {
					stack.push(c);
				} else if (isClose(c)) {
					if (stack.isEmpty()) {
						sb.append("no");
						over = true;
						break;
					}
					Character peek = stack.peek();
					if ((peek == '[' && c == ']') || (peek == '(' && c == ')'))
						stack.pop();
					else {
						over = true;
						sb.append("no");
						break;
					}
				}
			}
			if (!over) {
				if (stack.isEmpty())
					sb.append("yes");
				else sb.append("no");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}

	private static boolean isOpen(char c) {
		return c == '(' || c == '[';
	}
	private static boolean isClose(char c) {
		return c == ')' || c == ']';
	}
}
