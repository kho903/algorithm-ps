package boj.dp._5557;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        long[][] dp = new long[N - 1][21];
        dp[0][arr[0]] = 1;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    int x1 = j + arr[i];
                    int x2 = j - arr[i];
                    if (0 <= x1 && x1 <= 20) dp[i][x1] += dp[i - 1][j];
                    if (0 <= x2 && x2 <= 20) dp[i][x2] += dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N - 2][arr[N - 1]]);
    }

}
