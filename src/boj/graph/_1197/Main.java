package boj.graph._1197;

import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(stk.nextToken());
		int E = Integer.parseInt(stk.nextToken());
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		while (E-- > 0) {
			stk = new StringTokenizer(br.readLine());
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

	private static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
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