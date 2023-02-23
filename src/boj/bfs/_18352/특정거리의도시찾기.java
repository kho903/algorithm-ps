package boj.bfs._18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 특정거리의도시찾기 {
	static int N,M,X,K;
	static List<Integer>[] arr;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		X = Integer.parseInt(stk.nextToken());

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
		visited = new int[N + 1];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = -1;
		}

		bfs(X);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= N; i++) {
			if (visited[i] == K) sb.append(i).append("\n");
		}
		if (sb.length() == 0)
			System.out.println(-1);
		else
			System.out.print(sb);
	}

	private static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		visited[x]++;
		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			for (Integer p : arr[poll]) {
				if (visited[p] == -1) {
					visited[p] = visited[poll] + 1;
					queue.add(p);
				}
			}
		}
	}
}
