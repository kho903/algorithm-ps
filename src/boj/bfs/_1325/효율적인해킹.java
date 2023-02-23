package boj.bfs._1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적인해킹 {
	static int N, M;
	static List<Integer>[] arr;
	static boolean[] visited;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		answer = new int[N + 1];
		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			arr[a].add(b);
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			bfs(i);
		}
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, answer[i]);
		}

		for (int i = 1; i <= N; i++) {
			if (answer[i] == max) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}

	private static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visited[i] = true;
		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			for (Integer x : arr[poll]) {
				if (!visited[x]) {
					visited[x] = true;
					answer[x]++;
					queue.add(x);
				}
			}
		}
	}
}
