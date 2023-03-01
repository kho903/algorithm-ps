package softeer.lv2.바이러스;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(stk.nextToken());
		int p = Integer.parseInt(stk.nextToken());
		int n = Integer.parseInt(stk.nextToken());
		long[] arr = new long[n + 1];
		arr[0] = k;
		for (int i = 1; i <= n; i++)
			arr[i] = (arr[i - 1] * p) % 1000000007;

		System.out.println(arr[n]);
	}
}
