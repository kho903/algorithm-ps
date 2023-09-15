package boj.geometry._2166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());

		double[][] arr = new double[N][2];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			arr[i][0] = Double.parseDouble(stk.nextToken());
			arr[i][1] = Double.parseDouble(stk.nextToken());
		}

		double ans = 0;
		for (int i = 0; i < N; i++) {
			int x = i;
			int y = i + 1;
			if (y == N) y = 0;
			ans += (arr[x][0] * arr[y][1]);
			ans -= (arr[y][0] * arr[x][1]);
		}

		System.out.printf("%.1f\n", Math.abs(ans / 2.0));
	}
}
