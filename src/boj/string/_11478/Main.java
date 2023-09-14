package boj.string._11478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < N; j++) {
				sb.append(str.charAt(j));
				set.add(sb.toString());
			}
		}

		System.out.println(set.size());
	}
}
