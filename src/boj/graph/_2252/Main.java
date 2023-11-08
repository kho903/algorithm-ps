package boj.graph._2252;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[] order = new int[N + 1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            list[a].add(b);
            order[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (order[i] == 0)
                queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            sb.append(poll).append(' ');

            for (int i = 0; i < list[poll].size(); i++) {
                int cur = list[poll].get(i);
                order[cur]--;
                if (order[cur] == 0) queue.add(cur);
            }
        }
        System.out.println(sb);
    }
}
