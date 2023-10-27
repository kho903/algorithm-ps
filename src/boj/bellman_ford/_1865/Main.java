package boj.bellman_ford._1865;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, W;
    static ArrayList<Node>[] arr;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(stk.nextToken());
        StringBuilder sb = new StringBuilder();

        while (TC-- > 0) {
            stk = new StringTokenizer(br.readLine());
            N = Integer.parseInt(stk.nextToken());
            M = Integer.parseInt(stk.nextToken());
            W = Integer.parseInt(stk.nextToken());
            arr = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < M + W; i++) {
                stk = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(stk.nextToken());
                int E = Integer.parseInt(stk.nextToken());
                int T = Integer.parseInt(stk.nextToken());
                if (i < M) {
                    arr[S].add(new Node(E, T));
                    arr[E].add(new Node(S, T));
                } else arr[S].add(new Node(E, -T));
            }


            if (bellmanford())
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }

        System.out.print(sb);
    }

    public static boolean bellmanford() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean updated = false;

        for (int i = 1; i < N; i++) {
            updated = false;
            for (int j = 1; j <= N; j++) {
                for (Node node : arr[j]) {
                    if (dist[node.e] > dist[j] + node.value) {
                        dist[node.e] = dist[j] + node.value;
                        updated = true;
                    }
                }
            }
            if (!updated) break;
        }
        if (updated) {
            for (int i = 1; i <= N; i++) {
                for (Node node : arr[i]) {
                    if (dist[node.e] > dist[i] + node.value) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class Node {
        int e;
        int value;

        public Node(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }
}