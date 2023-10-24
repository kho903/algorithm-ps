package boj.binarysearch._1072;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(stk.nextToken());
		int Y = Integer.parseInt(stk.nextToken());
		int Z = percent(X, Y);
		int ans = -1;
		int s = 0;
		int e = 1_000_000_000;
		while (s <= e) {
			int mid = (s + e) / 2;
			int cur = percent(X + mid, Y + mid);
			if (cur != Z) {
				ans = mid;
				e = mid - 1;
			} else s = mid + 1;
		}
		System.out.println(ans);
	}

	private static int percent(int X, int Y) {
		return (int) ((long) Y * 100 / X);
	}
}
