package boj.dp._17404;

import java.io.*;
import java.util.*;

public class Main {
	static final int MAX = 1_000_001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int[][] arr = new int[N + 1][3];
		int[][] dp = new int[N + 1][3];

		int ans = MAX;

		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < 3; i++) {
				if (i == k) dp[1][i] = arr[1][i];
				else dp[1][i] = MAX;
			}

			for (int i = 2; i <= N; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
			}

			for (int i = 0; i < 3; i++) {
				if (i != k) ans = Math.min(ans, dp[N][i]);
			}
		}

		System.out.println(ans);
	}
}
