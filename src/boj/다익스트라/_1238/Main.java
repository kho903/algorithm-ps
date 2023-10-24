package boj.다익스트라._1238;

import java.io.*;
import java.util.*;

public class Main {
	static int N, X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		X = Integer.parseInt(stk.nextToken());

		List<Node>[] list = new ArrayList[N + 1];
		List<Node>[] listReverse = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
			listReverse[i] = new ArrayList<>();
		}


		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			int t = Integer.parseInt(stk.nextToken());

			list[s].add(new Node(e, t));
			listReverse[e].add(new Node(s, t));
		}

		int[] res1 = dijkstra(list);
		int[] res2 = dijkstra(listReverse);

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, res1[i] + res2[i]);
		}

		System.out.println(ans);
	}

	private static int[] dijkstra(List<Node>[] list) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X, 0));

		boolean[] check = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		while (!pq.isEmpty()) {
			Node poll = pq.poll();
			int to = poll.e;

			if (!check[to]) {
				check[to] = true;
				for (Node node : list[to]) {
					if (!check[node.e] && dist[node.e] > dist[to] + node.time) {
						dist[node.e] = dist[to] + node.time;
						pq.add(new Node(node.e, dist[node.e]));
					}
				}
			}
		}

		return dist;
	}

	static class Node implements Comparable<Node> {
		int e;
		int time;

		public Node(int e, int time) {
			this.e = e;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}

}
