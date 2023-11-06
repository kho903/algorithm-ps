package boj.bfs._2589;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, ans;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'L') {
                    visited = new boolean[N][M];
                    bfs(i, j);
                }
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Node(x, y, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]
                    && arr[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, node.value + 1));
                }
            }
            ans = Math.max(ans, node.value);
        }
    }

    static class Node {
        int x;
        int y;
        int value;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
