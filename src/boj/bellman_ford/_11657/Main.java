package boj.bellman_ford._11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long[] dist;
    static Node[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        arr = new Node[M];
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            arr[i] = new Node(a, b, c);
        }

        dist = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            dist[i] = Long.MAX_VALUE;
        }

        if (bellmanford(1)) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == Long.MAX_VALUE)
                    System.out.println(-1);
                else System.out.println(dist[i]);
            }
        }

    }

    private static boolean bellmanford(int start) {
        dist[start] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int s = arr[j].s;
                int e = arr[j].e;
                int v = arr[j].v;

                if (dist[s] == Long.MAX_VALUE) continue;
                if (dist[e] > dist[s] + v) {
                    dist[e] = dist[s] + v;
                    if (i == N - 1) return true;
                }
            }
        }
        return false;
    }

    static class Node {
        int s, e, v;

        public Node(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }
}
