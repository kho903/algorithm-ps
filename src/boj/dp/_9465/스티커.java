package boj.dp._9465;

import java.io.*;
import java.util.*;

public class 스티커 {
	static int[][] arr, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(stk.nextToken());
		for (int i = 0; i < T; i++) {
			stk = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(stk.nextToken());
			arr = new int[2][n + 1];
			dp = new int[2][n + 1];
			for (int j = 0; j < 2; j++) {
				stk = new StringTokenizer(br.readLine());
				for (int k = 1; k <= n; k++) {
					arr[j][k] = Integer.parseInt(stk.nextToken());
				}
			}
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];

			for (int j = 2; j <= n; j++) {
				dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
				dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
			}

			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}

		System.out.print(sb);
	}
}
