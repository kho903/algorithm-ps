package boj.dfs._2583;

import java.util.*;
import java.io.*;

public class Main {

    static int M, N, K, area;
    static boolean[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        arr = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    arr[y][x] = true;
                }
            }
        }

        List<Integer> areaList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!arr[i][j]) {
                    area = 0;
                    dfs(i, j);
                    areaList.add(area);
                }
            }
        }

        Collections.sort(areaList);
        sb.append(areaList.size()).append('\n');
        for (Integer x : areaList) {
            sb.append(x).append(' ');
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        arr[x][y] = true;
        area++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < M && 0 <= ny && ny < N && !arr[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

}
