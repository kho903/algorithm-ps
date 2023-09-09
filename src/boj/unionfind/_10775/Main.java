package boj.unionfind._10775;

import java.io.*;

public class Main {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());

		parents = new int[G + 1];
		for (int i = 1; i <= G; i++) {
			parents[i] = i;
		}

		int ans = 0;
		while (P-- > 0) {
			int gate = Integer.parseInt(br.readLine());
			int empty = find(gate);
			if (empty == 0) break;
			ans++;
			union(empty, empty - 1);
		}
		sb.append(ans);
		System.out.println(sb);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b) parents[b] = a;
		else parents[a] = b;
	}

	static int find(int x) {
		if (x == parents[x])
			return x;
		return parents[x] = find(parents[x]);
	}
}
