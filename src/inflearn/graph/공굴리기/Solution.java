package inflearn.graph.공굴리기;

import java.util.*;

public class Solution {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public int solution(int[][] board, int[] s, int[] e) {
		int n = board.length;
		int m = board[0].length;
		int[][] cost = new int[n][m];
		for (int[] ints : cost) {
			Arrays.fill(ints, Integer.MAX_VALUE);
		}
		cost[s[0]][s[1]] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.add(new int[] {s[0], s[1], 0});
		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			if (poll[2] > cost[poll[0]][poll[1]]) continue;
			for (int i = 0; i < 4; i++) {
				int x = poll[0];
				int y = poll[1];
				int L = poll[2];
				while (0 <= x && x < n && 0 <= y && y < m && board[x][y] == 0) {
					x += dx[i];
					y += dy[i];
					L++;
				}
				x -= dx[i];
				y -= dy[i];
				L--;
				if (cost[x][y] > L) {
					cost[x][y] = L;
					pq.add(new int[]{x, y, L});
				}
			}
		}
		if (cost[e[0]][e[1]] == Integer.MAX_VALUE) return -1;
		return cost[e[0]][e[1]];
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(
			new int[][] {{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0},
				{1, 0, 0, 0, 0, 0}}, new int[] {1, 0}, new int[] {4, 5}));
		System.out.println(T.solution(
			new int[][] {{0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 0},
				{1, 0, 0, 0, 0, 0}}, new int[] {0, 0}, new int[] {4, 2}));
		System.out.println(T.solution(
			new int[][] {{1, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}},
			new int[] {0, 3}, new int[] {4, 2}));
		System.out.println(T.solution(
			new int[][] {{0, 1, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 1, 1, 0, 1, 1},
				{0, 0, 0, 0, 0, 0}}, new int[] {0, 0}, new int[] {4, 5}));
		System.out.println(T.solution(
			new int[][] {{0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0}}, new int[] {0, 0}, new int[] {4, 3}));
	}
}
