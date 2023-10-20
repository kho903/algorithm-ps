package boj.binarysearch._2470;

import java.util.*;
import java.io.*;

public class Main {
	static final int MAX = 2_000_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int[] arr = new int[N];
		stk = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		Arrays.sort(arr);

		int s = 0;
		int l = N - 1;

		int gap = MAX;
		int ans1 = 0;
		int ans2 = 0;

		int tmp = 0;
		while (s < l) {
			tmp = Math.abs(arr[s] + arr[l]);
			if (tmp < gap) {
				gap = tmp;
				ans1 = arr[s];
				ans2 = arr[l];
			}
			if (arr[s] + arr[l] > 0) l--;
			else s++;
		}

		System.out.printf("%s %s\n", ans1, ans2);
	}
}
