package boj.greedy._1202;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        List<Node> arr = new ArrayList<>();
        int[] bag = new int[K];

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(stk.nextToken());
            int V = Integer.parseInt(stk.nextToken());
            arr.add(new Node(M, V));
        }
        arr.sort((o1, o2) -> o1.m - o2.m);

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);

        long ans = 0;
        int arrI = 0;

        for (int i = 0; i < K; i++) {
            while (arrI < N && arr.get(arrI).m <= bag[i]) {
                pq.add(arr.get(arrI++));
            }
            if (!pq.isEmpty()) ans += pq.poll().v;
        }
        System.out.println(ans);
    }

    static class Node {
        int m, v;

        public Node(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
