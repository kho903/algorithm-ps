package boj.greedy._1213;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = input.length();
		int[] arr = new int[26];
		for (int i = 0; i < N; i++) {
			int x = input.charAt(i) - 'A';
			arr[x]++;
		}

		int odd = 0;
		for (int x : arr) {
			if (x % 2 != 0) odd++;
		}
		if (odd > 1)
			System.out.println("I'm Sorry Hansoo");
		else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i] / 2; j++) {
					sb.append((char)(i + 65));
				}
			}
			StringBuilder answer = new StringBuilder(sb);
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] % 2 == 1) sb2.append((char) (i + 65));
			}
			sb.reverse();
			System.out.println(answer.append(sb2).append(sb));
		}
	}
}
