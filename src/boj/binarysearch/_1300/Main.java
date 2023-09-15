package boj.binarysearch._1300;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int s = 1;
		int l = k;
		int ans = 0;

		while (s <= l) {
			int mid = (s + l) / 2;
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}
			if (cnt < k)
				s = mid + 1;
			else {
				ans = mid;
				l = mid - 1;
			}
		}
		System.out.println(ans);
	}
}
