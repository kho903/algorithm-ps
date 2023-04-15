package inflearn.graph.방향바꾸기;

import java.util.*;

public class Solution {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	public int solution(int[][] board) {
		int answer = 0;
		int n = board.length;
		int m = board[0].length;
		int[][] cost = new int[n][m];
		for (int[] c : cost) {
			Arrays.fill(c, Integer.MAX_VALUE);
		}
		cost[0][0] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.add(new int[] {0, 0, 0});

		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			int dir = board[poll[0]][poll[1]] - 1;
			if (poll[2] > cost[poll[0]][poll[1]]) continue;
			for (int k = 0; k < 4; k++) {
				int nx = poll[0] + dx[k];
				int ny = poll[1] + dy[k];
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (k == dir && cost[nx][ny] > poll[2]) {
						cost[nx][ny] = poll[2];
						pq.offer(new int[] {nx, ny, poll[2]});
					} else if (k != dir && cost[nx][ny] > poll[2] + 1) {
						cost[nx][ny] = poll[2] + 1;
						pq.offer(new int[] {nx, ny, poll[2] + 1});
					}
				}
			}
		}

		return cost[n - 1][m - 1];
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[][] {{3, 1, 3}, {1, 4, 2}, {4, 2, 3}}));
		System.out.println(T.solution(new int[][] {{3, 2, 1, 3}, {1, 1, 4, 2}, {3, 4, 2, 1}, {1, 2, 2, 4}}));
		System.out.println(T.solution(
			new int[][] {{3, 2, 1, 3, 1, 2}, {2, 1, 1, 1, 4, 2}, {2, 2, 2, 1, 2, 2}, {1, 3, 3, 4, 4, 4},
				{1, 2, 2, 3, 3, 4}}));
		System.out.println(T.solution(
			new int[][] {{3, 2, 1, 3, 1, 2, 2, 2}, {2, 1, 1, 1, 4, 2, 1, 1}, {2, 2, 2, 1, 2, 2, 3, 4},
				{1, 3, 3, 4, 4, 4, 3, 1}, {1, 2, 2, 3, 3, 4, 3, 4}, {1, 2, 2, 3, 3, 1, 1, 1}}));
		System.out.println(T.solution(
			new int[][] {{1, 2, 3, 2, 1, 3, 1, 2, 2, 2}, {1, 2, 2, 1, 1, 1, 4, 2, 1, 1}, {3, 2, 2, 2, 2, 1, 2, 2, 3, 4},
				{3, 3, 1, 3, 3, 4, 4, 4, 3, 1}, {1, 1, 1, 2, 2, 3, 3, 4, 3, 4}, {1, 1, 1, 2, 2, 3, 3, 1, 1, 1}}));
	}
}