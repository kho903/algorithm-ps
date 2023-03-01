package boj.플로이드워셜._2660;

import java.io.*;
import java.util.*;

public class 회장뽑기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int[][] arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = 300;
			}
		}

		while (true) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			if (a == -1) break;
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		int max = Integer.MAX_VALUE;
		int[] score = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				score[i] = Math.max(score[i], arr[i][j]);
			}
			max = Math.min(max, score[i]);
		}


		List<Integer> hubo = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (score[i] == max) hubo.add(i);
		}

		System.out.println(max + " " + hubo.size());
		for (Integer x : hubo) {
			System.out.print(x + " ");
		}
	}
}
