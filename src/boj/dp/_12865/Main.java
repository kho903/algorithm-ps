package boj.dp._12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		dp = new int[K + 1];
		int[] w = new int[N + 1];
		int[] v = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(stk.nextToken());
			v[i] = Integer.parseInt(stk.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = K; j >= 0; j--) {
				if (j - w[i] >= 0) {
					dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
				}
			}
		}
		System.out.println(dp[K]);
	}
}
