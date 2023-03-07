package boj.string._11721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 열개씩끊어출력하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = str.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(str.charAt(i));
			if (i % 10 == 9) {
				System.out.println(sb);
				sb = new StringBuilder();
			}
		}
		if (sb.length() != 0)
			System.out.println(sb);
	}
}
