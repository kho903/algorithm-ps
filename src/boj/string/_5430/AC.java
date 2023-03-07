package boj.string._5430;

import java.io.*;
import java.util.*;

public class AC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String[] p = br.readLine().split("");
			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(",");
			Deque<Integer> deque = new LinkedList<>();
			for (int j = 0; j < n; j++) {
				if (arr[0].charAt(0) == '[' && arr[0].charAt(arr[0].length() - 1) == ']') {
					String substring = arr[j].substring(1);
					substring = substring.substring(0, substring.length() - 1);
					deque.add(Integer.parseInt(substring));
				} else if (j == 0) {
					String substring = arr[j].substring(1);
					deque.add(Integer.parseInt(substring));
				} else if (j == n - 1) {
					String substring = arr[j].substring(0, arr[j].length() - 1);
					deque.add(Integer.parseInt(substring));
				} else
					deque.add(Integer.parseInt(arr[j]));
			}

			boolean isLeft = true;
			boolean isEnd = false;
			for (String s : p) {
				if (s.equals("R")) {
					if (isLeft) isLeft = false;
					else isLeft = true;
				} else if (s.equals("D")) {
					if (deque.isEmpty()) {
						sb.append("error").append("\n");
						isEnd = true;
						break;
					} else if (isLeft) {
						deque.pollFirst();
					} else {
						deque.pollLast();
					}
				}
			}
			if (!isEnd) {
				sb.append("[");
				if (isLeft) {
					while (!deque.isEmpty()) {
						sb.append(deque.pollFirst());
						if (!deque.isEmpty())
							sb.append(",");
					}
				} else {
					while (!deque.isEmpty()) {
						sb.append(deque.pollLast());
						if (!deque.isEmpty())
							sb.append(",");
					}
				}
				sb.append("]").append("\n");
			}
		}
		System.out.print(sb);
	}
}
