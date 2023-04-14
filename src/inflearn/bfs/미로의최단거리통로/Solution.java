package inflearn.bfs.미로의최단거리통로;

import java.util.*;

public class Solution {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int answer;

	static int N = 7;

	public int solution(int[][] board) {
		answer = Integer.MAX_VALUE;
		boolean[][] check = new boolean[N][N];
		int[][] dist = new int[N][N];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0});
		int x = 0;
		while (!queue.isEmpty()) {
			x++;
			int size = queue.size();
			while (size-- > 0) {
				int[] poll = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nx = poll[0] + dx[i];
					int ny = poll[1] + dy[i];
					if (check(nx, ny, board)) {
						board[nx][ny] = 1;
						dist[nx][ny] = x;
						queue.add(new int[] {nx, ny});
					}
				}
			}
		}
		if (dist[N - 1][N - 1] == 0)
			return -1;
		return dist[N - 1][N - 1];
	}

	private boolean check(int nx, int ny, int[][] board) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] != 1;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		int[][] arr = {
			{0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 1, 0, 0, 0},
			{1, 1, 0, 1, 0, 1, 1},
			{1, 1, 0, 1, 0, 0, 0},
			{1, 0, 0, 0, 1, 0, 0},
			{1, 0, 1, 0, 0, 0, 0}
		};
		System.out.println(T.solution(arr));
		arr = new int[][] {
			{0, 0, 0, 0, 0, 0, 0},
			{0, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 1, 0, 0, 0},
			{1, 1, 0, 1, 1, 1, 1},
			{1, 1, 0, 1, 0, 0, 0},
			{1, 0, 0, 0, 1, 0, 0},
			{1, 0, 1, 0, 1, 0, 0}
		};
		System.out.println(T.solution(arr));
	}
}