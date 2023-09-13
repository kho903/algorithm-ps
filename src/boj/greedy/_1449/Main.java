package boj.greedy._1449;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(arr);

		int cnt = 0;
		boolean[] ch = new boolean[1001 + M];

		for (int i = 0; i < N; i++) {
			int idx = arr[i];
			if (!ch[idx]) {
				cnt++;
				for (int j = idx; j < idx + M; j++) {
					ch[j] = true;
				}
			}
		}
		System.out.println(cnt);
	}
}
