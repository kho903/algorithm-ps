package boj.greedy._11501;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(stk.nextToken());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int[] arr = new int[N];
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}
			int max = arr[N - 1];
			long answer = 0;
			for (int i = N - 2; i >= 0; i--) {
				if (arr[i] <= max) {
					answer += max - arr[i];
				} else {
					max = arr[i];
				}
			}
			sb.append(answer).append('\n');
		}
		System.out.print(sb);
	}
}
