package boj.tree._9934;

import java.io.*;
import java.util.*;

public class Main {

    static int K;
    static int[] arr;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        int len = (int) Math.pow(2, K) - 1;
        arr = new int[len];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        list = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            list[i] = new ArrayList<>();
        }

        recursion(0, len - 1, 0);
        for (List<Integer> integers : list) {
            for (Integer x : integers) {
                sb.append(x).append(' ');
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void recursion(int s, int e, int depth) {
        if (depth == K) return;
        int mid = (s + e) / 2;

        list[depth].add(arr[mid]);

        recursion(s, mid - 1, depth + 1);
        recursion(mid + 1, e,  depth + 1);
    }
}
