package boj.dfs._17070;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] arr;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        ans = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(1, 2, 0);
        System.out.println(ans);
    }

    private static void dfs(int x, int y, int d) {
        if (x == N && y == N) {
            ans++;
            return;
        }

        switch (d) {
            case 0: // 가로
                if (y + 1 <= N && arr[x][y + 1] == 0) // 가로
                    dfs(x, y + 1, 0);
                if (x + 1 <= N && y + 1 <= N && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) // 대각선
                    dfs(x + 1, y + 1, 2);
                break;
            case 1: // 세로
                if (x + 1 <= N && arr[x + 1][y] == 0) // 세로
                    dfs(x + 1, y , 1);
                if (x + 1 <= N && y + 1 <= N && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) // 대각선
                    dfs(x + 1, y + 1, 2);
                break;
            case 2:
                if (x + 1 <= N && arr[x + 1][y] == 0) // 세로
                    dfs(x + 1, y , 1);
                if (y + 1 <= N && arr[x][y + 1] == 0) // 가로
                    dfs(x, y + 1, 0);
                if (x + 1 <= N && y + 1 <= N && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) // 대각선
                    dfs(x + 1, y + 1, 2);
                break;
        }
    }

}
