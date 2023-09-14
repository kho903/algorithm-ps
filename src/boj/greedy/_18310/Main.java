package boj.greedy._18310;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int[] home = new int[N];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(home);
		System.out.println(home[(N - 1) / 2]);

	}
}
