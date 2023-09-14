package boj.dfs._1520;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr, dp;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		// 문제에 나와 있는 N, M을 변경함. (평소에 이게 편해서.)
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		arr = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0, 0));
	}

	private static int dfs(int x, int y) {
		if (x == N - 1 && y == M - 1) return 1;
		if (dp[x][y] != -1) return dp[x][y];

		dp[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (check(nx, ny) && arr[x][y] > arr[nx][ny]) {
				dp[x][y] += dfs(nx, ny);
			}
		}
		return dp[x][y];
	}

	private static boolean check(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
