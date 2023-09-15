package boj.string._20437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String W = br.readLine();
			int K = Integer.parseInt(br.readLine());

			if (K == 1) {
				sb.append(1).append(' ').append(1).append('\n');
				continue;
			}
			int Wlen = W.length();
			int[] alpha = new int[26];
			int min = Integer.MAX_VALUE;
			int max = -1;

			for (int i = 0; i < Wlen; i++) {
				alpha[W.charAt(i) - 'a']++;
			}

			for (int i = 0; i < Wlen; i++) {
				if (alpha[W.charAt(i) - 'a'] < K) continue;
				int cnt = 1;
				for (int j = i + 1; j < Wlen; j++) {
					if (W.charAt(i) == W.charAt(j))
						cnt++;
					if (cnt == K) {
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1);
						break;
					}
				}
			}

			if (min == Integer.MAX_VALUE || max == -1) sb.append(-1).append('\n');
			else sb.append(min).append(' ').append(max).append('\n');
		}
		System.out.print(sb);
	}
}
