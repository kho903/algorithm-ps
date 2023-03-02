package boj.dp._2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int[][] arr = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				arr[i][j] = Integer.parseInt(stk.nextToken());
		}

		int[][] min = new int[N + 1][3];
		int[][] max = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + arr[i][0];
			min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + arr[i][1];
			min[i][2] = Math.min(min[i - 1][2], min[i - 1][1]) + arr[i][2];

			max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + arr[i][0];
			max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + arr[i][1];
			max[i][2] = Math.max(max[i - 1][2], max[i - 1][1]) + arr[i][2];
		}

		int minRes = Integer.MAX_VALUE;
		int maxRes = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			minRes = Math.min(minRes, min[N][i]);
			maxRes = Math.max(maxRes, max[N][i]);
		}
		System.out.printf("%d %d\n", maxRes, minRes);
	}
}
