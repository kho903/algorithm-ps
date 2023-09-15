package boj.graph._6497;

import java.io.*;
import java.util.*;

public class Main {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			if (m == 0 && n == 0) break;
			parent = new int[m + 1];
			for (int i = 1; i <= m; i++) {
				parent[i] = i;
			}

			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				int z = Integer.parseInt(stk.nextToken());
				pq.offer(new Node(x, y, z));
			}

			int ans = 0;
			int total = 0;
			while (!pq.isEmpty()) {
				Node node = pq.poll();
				int to = find(node.to);
				int from = find(node.from);
				total += node.value;
				if (to != from) {
					ans += node.value;
					union(node.to, node.from);
				}
			}
			sb.append(total - ans).append('\n');
		}
		System.out.print(sb);
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}
}

class Node implements Comparable<Node> {
	int to;
	int from;
	int value;

	public Node(int to, int from, int value) {
		this.to = to;
		this.from = from;
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}
}
