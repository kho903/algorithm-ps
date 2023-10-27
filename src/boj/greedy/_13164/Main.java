package boj.greedy._13164;

import java.util.*;
import java.io.*;

public class Main {

    static int N, K, ans;
    static int[] arr;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());
        arr = new int[N];
        list = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        ans = 0;
        calc();

        System.out.println(ans);
    }

    private static void calc() {
        for (int i = 1; i < N; i++) {
            list.add(arr[i] - arr[i - 1]);
        }

        Collections.sort(list);
        for (int i = 0; i < N - K; i++) {
            ans += list.get(i);
        }
    }

}
