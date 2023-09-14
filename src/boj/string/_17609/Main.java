package boj.string._17609;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (N-- > 0) {
			String str = br.readLine();
			sb.append(checkPalin(str, 0, 0, str.length() - 1)).append('\n');
		}
		System.out.print(sb);
	}

	private static int checkPalin(String str, int x, int s, int l) {

		if (x == 2) return 2;

		while (s <= l) {
			if (str.charAt(s) == str.charAt(l)) {
				s++;
				l--;
			} else {
				x = Integer.min(checkPalin(str, x + 1, s + 1, l), checkPalin(str, x + 1, s, l - 1));
				break;
			}
		}

		return x;
	}
}
