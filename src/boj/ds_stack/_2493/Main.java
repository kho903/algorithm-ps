package boj.ds_stack._2493;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		Stack<Top> top = new Stack<>();

		for (int i = 1; i <= N; i++) {
			int height = Integer.parseInt(stk.nextToken());

			if (top.isEmpty()) {
				sb.append(0).append(" ");
				top.push(new Top(i, height));
			} else {
				while (true) {
					if (top.isEmpty()) {
						sb.append(0).append(" ");
						top.push(new Top(i, height));
						break;
					}
					Top peek = top.peek();
					if (peek.height > height) {
						sb.append(peek.idx).append(" ");
						top.push(new Top(i, height));
						break;
					} else top.pop();
				}
			}
		}

		System.out.println(sb);
	}
}

class Top {
	int idx;
	int height;

	public Top(int idx, int height) {
		this.idx = idx;
		this.height = height;
	}
}