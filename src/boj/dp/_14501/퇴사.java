package boj.dp._14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] D = new int[N + 2];

		int[] day = new int[N + 1];
		int[] pay = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(stk.nextToken());
			pay[i] = Integer.parseInt(stk.nextToken());
		}

		for (int i = N; i > 0; i--) {
			if (i + day[i] > N + 1) {
				D[i] = D[i + 1];
			} else {
				D[i] = Math.max(D[i + 1], pay[i] + D[i + day[i]]);
			}
		}
		System.out.println(D[1]);
	}
}
