package boj.투포인터._2467;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(stk.nextToken());
		}

		Arrays.sort(arr);
		int s = 0;
		int l = N - 1;
		int small = 0;
		int big = 0;
		long sum = Long.MAX_VALUE;

		while (s < l) {
			long curSum = arr[s] + arr[l];
			if (Math.abs(sum) > Math.abs(curSum)) {
				small = s;
				big = l;
				sum = curSum;
			}
			if (curSum == 0)
				break;
			else if (curSum > 0)
				l--;
			else
				s++;
		}
		System.out.println(arr[small] + " " + arr[big]);

	}
}
