package boj.플로이드워셜._1613;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        boolean[][] arr = new boolean[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            arr[a][b] = true;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][k] && arr[k][j]) arr[i][j] = true;
                }
            }
        }

        int S = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (S-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            if (!check(a, b)) {
                sb.append(-1).append('\n');
            } else if (arr[a][b]) sb.append(-1).append('\n');
            else if (arr[b][a]) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }
        System.out.print(sb);
    }

    private static boolean check(int a, int b) {
        return 0 < a && a <= N && 0 < b && b <= N;
    }

}
