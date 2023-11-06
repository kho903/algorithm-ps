package boj.dp._12852;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] dp = new Node[N + 1];
        dp[1] = new Node(0, "1");

        for (int i = 2; i <= N; i++) {
            int cnt = Integer.MAX_VALUE;
            int before = 0;

            if (i % 3 == 0) {
                cnt = dp[i / 3].value;
                before = i / 3;
            }

            if (i % 2 == 0 && cnt > dp[i / 2].value) {
                cnt = dp[i / 2].value;
                before = i / 2;
            }

            if (cnt > dp[i - 1].value) {
                before = i - 1;
            }

            dp[i] = new Node(dp[before].value + 1, i + " " + dp[before].trace);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[N].value).append("\n").append(dp[N].trace);
        System.out.println(sb);
    }

    static class Node {
        int value;
        String trace;

        public Node(int value, String trace) {
            this.value = value;
            this.trace = trace;
        }
    }
}
