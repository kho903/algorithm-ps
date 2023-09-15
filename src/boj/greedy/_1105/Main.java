package boj.greedy._1105;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		String L = stk.nextToken();
		String R = stk.nextToken();
		int cnt = 0;

		if (L.length() == R.length()) {
			for (int i = 0; i < L.length(); i++) {
				if (L.charAt(i) != R.charAt(i)) break;
				if (L.charAt(i) == '8') cnt++;
			}
		}
		System.out.println(cnt);
	}
}
