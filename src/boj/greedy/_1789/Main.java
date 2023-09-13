package boj.greedy._1789;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long sum = 0L;
		int cnt = 0;

		for (int i = 1; ; i++) {
			if (sum > N) break;
			sum += i;
			cnt++;
		}
		System.out.println(cnt - 1);
	}
}
