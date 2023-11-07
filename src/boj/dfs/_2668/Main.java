package boj.dfs._2668;

import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        list = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        sb.append(list.size()).append('\n');
        Collections.sort(list);
        for (Integer x : list) {
            sb.append(x).append('\n');
        }
        System.out.print(sb);

    }

    private static void dfs(int s, int t) {
        if (!visited[arr[s]]) {
            visited[arr[s]] = true;
            dfs(arr[s], t);
            visited[arr[s]] = false;
        }
        if (arr[s] == t)
            list.add(t);
    }

}
