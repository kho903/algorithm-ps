package boj.math._11444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long MOD = 1_000_000_007;
    static long[][] arr = {
        {1, 1},
        {1, 0}
    };
    static int len = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        System.out.println(pow(N)[0][1]);
    }

    private static long[][] pow(long n) {
        if (n == 1) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    arr[i][j] %= MOD;
                }
            }
            return arr;
        }
        long[][] tmp = pow(n / 2);

        if (n % 2 == 1) return multi(multi(tmp, tmp), arr);
        else return multi(tmp, tmp);
    }

    private static long[][] multi(long[][] A, long[][] B) {
        long[][] C = new long[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                    C[i][j] %= MOD;
                }
            }
        }
        return C;
    }

}
