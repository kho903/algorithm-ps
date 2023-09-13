package boj.dfs._2468;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int N, max;
	static boolean[][] visited;
	static int[] dx = new int[] {0, 0, 1, -1};
	static int[] dy = new int[] {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken());
		arr = new int[N][N];
		max = -1;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}

		int ans = 0;
		for (int i = 1; i <= max; i++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!visited[j][k] && i <= arr[j][k]) {
						cnt++;
						dfs(j, k, i);
					}
				}
			}
			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);
	}

	private static void dfs(int x, int y, int h) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (check(nx, ny, h)) {
				visited[nx][ny] = true;
				dfs(nx, ny, h);
			}
		}
	}

	private static boolean check(int nx, int ny, int h) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N && h <= arr[nx][ny] && !visited[nx][ny];
	}

}
