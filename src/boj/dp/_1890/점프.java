package boj.dp._1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int[][] arr = new int[N + 1][N + 1];
		long[][] dp = new long[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		dp[1][1] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int cur = arr[i][j];
				if (cur == 0) break;
				if (i + cur <= N) dp[i + cur][j] += dp[i][j];
				if (j + cur <= N) dp[i][j + cur] += dp[i][j];
			}
		}
		System.out.println(dp[N][N]);
	}
}
