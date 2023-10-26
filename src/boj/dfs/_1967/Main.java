package boj.dfs._1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, ans;
    static List<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        ans = 0;
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());
            int len = Integer.parseInt(stk.nextToken());

            list[s].add(new Node(e, len));
            list[e].add(new Node(s, len));
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(ans);
    }

    private static void dfs(int x, int l) {
        for (Node node : list[x]) {
            if (!visited[node.n]) {
                visited[node.n] = true;
                dfs(node.n, l + node.len);
            }
        }
        ans = Math.max(ans, l);
    }

    static class Node {

        int n;
        int len;

        public Node(int n, int len) {
            this.n = n;
            this.len = len;
        }
    }
}
