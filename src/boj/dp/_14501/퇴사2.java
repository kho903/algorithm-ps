package boj.dp._14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사2 {
	static int ans = 0;
	static int N;
	static int[] D;
	static int[] pay;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		D = new int[N + 1];
		pay = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			D[i] = Integer.parseInt(stk.nextToken());
			pay[i] = Integer.parseInt(stk.nextToken());
		}

		calc(1, 0);
		System.out.println(ans);
	}

	public static void calc(int day, int s) {
		if (day == N + 1) {
			ans = Math.max(ans, s);
		} else if (day > N + 1) return;
		else {
			calc(day + 1, s);
			calc(D[day] + day, s + pay[day]);
		}
	}
}
