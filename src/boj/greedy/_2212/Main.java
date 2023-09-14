package boj.greedy._2212;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(stk.nextToken());
		if (K >= N) {
			System.out.println(0);
			return;
		}

		stk = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(arr);
		int[] calc = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			calc[i] = arr[i + 1] - arr[i];
		}
		Arrays.sort(calc);
		int answer = 0;
		for (int i = 0; i < N - K; i++) {
			answer += calc[i];
		}
		System.out.println(answer);
	}
}
