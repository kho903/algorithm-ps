package boj.string._10953;

import java.io.*;

public class AplusBminus6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] s = br.readLine().split(",");
			sb.append(Integer.parseInt(s[0]) + Integer.parseInt(s[1])).append("\n");
		}
		System.out.print(sb);
	}
}
