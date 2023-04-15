package inflearn.graph.벽허물기;

import java.util.*;

public class Solution {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public int solution(int[][] board) {
		int n = board.length;
		int m = board[0].length;
		int[][] cost = new int[n][m];
		for (int[] ints : cost) {
			Arrays.fill(ints, Integer.MAX_VALUE);
		}
		cost[0][0] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.add(new int[] {0, 0, 0});
		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			if (poll[2] > cost[poll[0]][poll[1]]) continue;
			for (int i = 0; i < 4; i++) {
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];
				if (0 <= nx && nx < n && 0 <= ny && ny < m) {
					if (board[nx][ny] == 0 && cost[nx][ny] > poll[2]) {
						cost[nx][ny] = poll[2];
						pq.offer(new int[] {nx, ny, poll[2]});
					} else if (board[nx][ny] == 1 && cost[nx][ny] > poll[2] + 1) {
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
		System.out.println(T.solution(new int[][] {{0, 1, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 0}}));
		System.out.println(
			T.solution(new int[][] {{0, 1, 1, 0}, {1, 1, 0, 1}, {0, 0, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 0}}));
		System.out.println(T.solution(
			new int[][] {{0, 1, 1, 0, 1, 1}, {0, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 1},
				{1, 1, 0, 1, 1, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 0}}));
		System.out.println(T.solution(
			new int[][] {{0, 1, 1, 0, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 0, 1, 1, 1},
				{1, 1, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 0}}));
		System.out.println(T.solution(
			new int[][] {{0, 0, 1, 0, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1}, {1, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 1, 1},
				{1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 1},
				{1, 1, 0, 1, 1, 1, 0}}));
	}
}
