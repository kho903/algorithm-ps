package boj.unionfind._4195;

import java.io.*;
import java.util.*;

public class Main {

	static int[] parents, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(stk.nextToken());
		while (T-- > 0) {
			stk = new StringTokenizer(br.readLine());
			int F = Integer.parseInt(stk.nextToken());
			parents = new int[2 * F];
			rank = new int[2 * F];
			Map<String, Integer> map = new HashMap<>();
			for (int i = 0; i < 2 * F; i++) {
				parents[i] = i;
				rank[i] = 1;
			}

			int idx = 0;
			for (int i = 0; i < F; i++) {
				stk = new StringTokenizer(br.readLine());
				String a = stk.nextToken();
				String b = stk.nextToken();

				if (!map.containsKey(a))
					map.put(a, idx++);

				if (!map.containsKey(b))
					map.put(b, idx++);

				sb.append(union(map.get(a), map.get(b))).append('\n');
			}
		}
		System.out.print(sb);
	}

	private static int union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parents[b] = a;
			rank[a] += rank[b];
		}

		return rank[a];
	}

	private static int find(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}
}
