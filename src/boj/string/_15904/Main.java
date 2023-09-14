package boj.string._15904;

import java.io.*;

public class Main {
	static char[] ucpc = new char[] {'U', 'C', 'P', 'C'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(check(str));
	}

	private static String check(String str) {
		int ui = 0;
		int N = str.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (ui == 4) break;
			if (str.charAt(i) == ucpc[ui]) {
				ui++;
				sb.append(str.charAt(i));
			}
		}
		if (sb.toString().equals("UCPC")) return "I love UCPC";
		return "I hate UCPC";
	}
}
