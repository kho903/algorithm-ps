package boj.bfs._7576;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] arr;
	static boolean[][] visited;
	static int m, n;
	static Queue<int[]> queue = new LinkedList<>();

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		m = Integer.parseInt(stk.nextToken());
		n = Integer.parseInt(stk.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
				if (arr[i][j] == 1) queue.add(new int[] {i, j});
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (check(nx, ny)) {
					queue.add(new int[] {nx, ny});
					arr[nx][ny] = arr[x][y] + 1;
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) return -1;
				max = Math.max(max, arr[i][j]);
			}
		}
		if (max == 1) return 0;
		else return max - 1;
	}

	public static boolean check(int nx, int ny) {
		return 0 <= nx && nx < n && 0 <= ny && ny < m && arr[nx][ny] == 0;
	}
}
