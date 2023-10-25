package boj.string._9935;

import java.io.*;
import java.util.*;

public class 문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		int bombLen = bomb.length();
		int N = str.length();
		for (int i = 0; i < N; i++) {
			stack.push(str.charAt(i));

			if (stack.size() >= bombLen) {
				boolean same = true;

				for (int j = 0; j < bombLen; j++) {
					if (stack.get(stack.size() - bombLen + j) != bomb.charAt(j)) {
						same = false;
						break;
					}
				}
				if (same) {
					for (int j = 0; j < bombLen; j++) {
						stack.pop();
					}
				}
			}
		}
		while (!stack.isEmpty()) sb.append(stack.pop());

		if (sb.length() == 0)
			System.out.println("FRULA");
		else
			System.out.println(sb.reverse());
	}
}
