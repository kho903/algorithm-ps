package boj.dfs._4963;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static boolean[][] visited;

	static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
	static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
	static int n, m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			int answer = 0;
			StringTokenizer stk = new StringTokenizer(br.readLine());
			m = Integer.parseInt(stk.nextToken());
			n = Integer.parseInt(stk.nextToken());
			if (m == 0 && n == 0) break;
			arr = new int[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						answer++;
					}
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.print(sb);
	}

	private static void dfs(int x, int y) {
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (check(nx, ny) && !visited[nx][ny] && arr[nx][ny] == 1) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

	private static boolean check(int x, int y) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}
}
