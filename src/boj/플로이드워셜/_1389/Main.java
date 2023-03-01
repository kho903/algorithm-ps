package boj.플로이드워셜._1389;

import java.io.*;
import java.util.*;

public class Main {

	static final int MAX = 500001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int[][] arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) arr[i][j] = 0;
				else arr[i][j] = MAX;
			}
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}


		for (int k = 1; k <= N; k++) {
			for (int i = 1; i<= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j) continue;
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		int min = MAX;
		int idx = -1;

		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += arr[i][j];
			}
			if (min > sum) {
				min = sum;
				idx = i;
			}
		}
		System.out.println(idx);
	}
}
