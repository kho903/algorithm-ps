package boj.dp._1965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상자넣기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int[] arr = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
		}

		int ans = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
