package algo_study.최소스패닝트리.크루스칼알고리즘;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	private static int n;
	private static int[] parents;

	public static void main(String[] args) {
		n = 7;
		int[][] graph = {
			{1, 2, 29},
			{1, 5, 75},
			{2, 3, 35},
			{2, 6, 34},
			{3, 4, 7},
			{4, 6, 23},
			{4, 7, 13},
			{5, 6, 53},
			{6, 7, 25}
		};

		parents = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			parents[i] = i;
		}

		Queue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < graph.length; i++) {
			int to = graph[i][0];
			int from = graph[i][1];
			int value = graph[i][2];
			pq.add(new Node(to, from, value));
		}

		int size = pq.size();
		int total = 0;
		for (int i = 0; i < size; i++) {
			Node node = pq.poll();
			int rx = find(node.to);
			int ry = find(node.from);

			if (rx != ry) {
				total += node.value;
				union(node.to, node.from);
			}
		}
		System.out.println(total);
	}

	private static int find(int x) {
		if (parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y) {
			parents[y] = x;
		} else {
			parents[x] = y;
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
