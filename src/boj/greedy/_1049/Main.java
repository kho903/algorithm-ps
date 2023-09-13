package boj.greedy._1049;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		int minP = Integer.MAX_VALUE;
		int minV = Integer.MAX_VALUE;
		while (M-- > 0) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());

			minP = Math.min(minP, a);
			minV = Math.min(minV, b);
		}
		int ans = 0;
		if (minP / 6 >= minV) {
			ans = minV * N;
		} else {
			int pCnt = N / 6;
			int pRemain = N % 6;
			ans += pCnt * minP;
			ans += Math.min(pRemain * minV, minP);
		}

		System.out.println(ans);
	}
}
