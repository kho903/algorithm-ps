package inflearn.graph.최소비행료;

import java.util.*;

class Solution {
	public int solution(int n, int[][] flights, int s, int e, int k) {
		int[][] arr = new int[n][n];
		for (int[] ints : arr) {
			Arrays.fill(ints, Integer.MAX_VALUE);
		}

		for (int[] flight : flights) {
			int a = flight[0];
			int b = flight[1];
			int c = flight[2];
			arr[a][b] = c;
		}

		int[] costs = new int[n];
		Arrays.fill(costs, Integer.MAX_VALUE);

		Queue<int[]> q = new LinkedList<>();
		int L = 0;
		q.add(new int[] {s, 0});
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] poll = q.poll();
				int x = poll[0];
				for (int i = 0; i < n; i++) {
					if (arr[x][i] != Integer.MAX_VALUE && poll[1] + arr[x][i] < costs[i]) {
						costs[i] = poll[1] + arr[x][i];
						q.offer(new int[] {i, costs[i]});
					}
				}
			}
			L++;
			if (L > k) break;
		}

		if (costs[e] == Integer.MAX_VALUE) return -1;
		return costs[e];
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(5,
			new int[][] {{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30},
				{3, 4, 10}}, 0, 3, 1));
		System.out.println(T.solution(4, new int[][] {{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
		System.out.println(T.solution(8,
			new int[][] {{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5},
				{2, 3, 3}}, 1, 7, 2));
		System.out.println(T.solution(10,
			new int[][] {{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100},
				{0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
	}
}