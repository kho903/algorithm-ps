package boj.dfs._9466;

import java.io.*;
import java.util.*;

public class Main {
	static int N, cnt;
	static int[] students;
	static boolean[] visited;
	static boolean[] finished;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(stk.nextToken());
		while (T-- > 0) {
			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			cnt = 0;
			students = new int[N + 1];
			visited = new boolean[N + 1];
			finished = new boolean[N + 1];

			stk = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				students[i] = Integer.parseInt(stk.nextToken());
			}
			for (int i = 1; i <= N; i++) {
				dfs(i);
			}
			sb.append(N - cnt).append('\n');
		}

		System.out.print(sb);
	}

	private static void dfs(int cur) {
		if (visited[cur]) return;

		visited[cur] = true;
		int next = students[cur];


		if (!visited[next]) dfs(next);
		else if (!finished[next]) {
			cnt++;
			for (int i = next; i != cur; i = students[i])
				cnt++;
		}

		finished[cur] = true;
	}
}
