package boj.binarysearch._12738;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        for (int i = 1; i <= N; i++) {
            int num = arr[i];
            int l = 1;
            int r = list.size() - 1;
            if (num > list.get(r)) {
                list.add(num);
            } else {
                while (l < r) {
                    int m = (l + r) / 2;
                    if (list.get(m) >= num) r = m;
                    else l = m + 1;
                }
                list.set(r, num);
            }
        }
        System.out.println(list.size() - 1);
    }
}
