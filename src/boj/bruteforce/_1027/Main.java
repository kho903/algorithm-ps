package boj.bruteforce._1027;

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		arr = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, sol(i));
		}

		System.out.println(ans);
	}

	private static int sol(int idx) {
		int cnt = 0;

		double tmp = 0.0;

		// 왼쪽
		for (int i = idx - 1; i >= 0; i--) {
			double x = (double)(arr[idx] - arr[i]) / (idx - i);
			if (i == idx - 1 || tmp > x) {
				cnt++;
				tmp = x;
			}
		}

		// 오른쪽
		tmp = 0.0;
		for (int i = idx + 1; i < N; i++) {
			double x = (double)(arr[idx] - arr[i]) / (idx - i);
			if (i == idx + 1 || tmp < x) {
				cnt++;
				tmp = x;
			}
		}
		return cnt;
	}
}
