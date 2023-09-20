package programmers.lv3;

import java.util.*;

public class 섬연결하기 {

	static int[] parent;
	public int solution(int n, int[][] costs) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();

		for (int[] cost : costs) {
			pq.offer(new Node(cost[0], cost[1], cost[2]));
		}

		int ans = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int x = node.x;
			int y = node.y;
			if (find(x) != find(y)) {
				ans += node.v;
				union(x, y);
			}
		}

		return ans;
	}

	public int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	public void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int v;

		Node(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public int compareTo(Node o) {
			return this.v - o.v;
		}
	}
}
