package boj.unionfind._1717;

import java.io.*;
import java.util.*;

public class Main {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		parents = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(stk.nextToken());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());

			if (c == 0) {
				union(a, b);
			} else {
				sb.append(find(a) != find(b) ? "NO" : "YES").append("\n");
			}
		}
		System.out.print(sb);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b)
			parents[b] = a;
		else
			parents[a] = b;
	}

	private static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
}
