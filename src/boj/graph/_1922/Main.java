package boj.graph._1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		while (M-- > 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			pq.offer(new Node(a, b, c));
		}

		int ans = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int to = find(node.to);
			int from = find(node.from);
			if (to != from) {
				ans += node.value;
				union(node.to, node.from);
			}
		}
		System.out.println(ans);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y)
			parent[y] = x;
		else parent[x] = y;
	}

	private static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
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
