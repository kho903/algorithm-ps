package boj.플로이드워셜._11403;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(stk.nextToken());
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][k] == 1 && arr[k][j] == 1)
						arr[i][j] = 1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int[] ar : arr) {
			for (int x : ar) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
