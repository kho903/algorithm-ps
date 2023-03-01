package softeer.lv3.성적평균;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int s = 0;
			for (int j = a; j <= b; j++) {
				s += arr[j];
			}
			double score = (double)s / (b - a + 1);
			sb.append(String.format("%.2f", score)).append("\n");
		}

		System.out.println(sb);
	}
}
