package boj.string._17413;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();

		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		boolean flag = false;

		for (int i = 0; i < N; i++) {
			if (str.charAt(i) == '<') {
				makeString(sb, stack);
				flag = true;
				sb.append('<');
				continue;
			} else if (str.charAt(i) == '>') {
				flag = false;
				sb.append('>');
				continue;
			}

			if (flag) {
				sb.append(str.charAt(i));
			} else {
				if (str.charAt(i) == ' ') {
					makeString(sb, stack);
					sb.append(' ');
				} else {
					stack.push(str.charAt(i));
				}
			}
		}

		makeString(sb, stack);
		System.out.println(sb);
	}

	private static void makeString(StringBuilder sb, Stack<Character> stack) {
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
	}
}
