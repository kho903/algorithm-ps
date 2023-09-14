package boj.string._1251;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = str.length();
		List<String> arr = new ArrayList<>();
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				arr.add(sol(str, i, j));
			}
		}
		Collections.sort(arr);
		System.out.println(arr.get(0));
	}

	private static String sol(String str, int x, int y) {
		StringBuilder sb1 = new StringBuilder(str.substring(0, x));
		StringBuilder sb2 = new StringBuilder(str.substring(x, y));
		StringBuilder sb3 = new StringBuilder(str.substring(y));
		StringBuilder sb = new StringBuilder(sb1.reverse());
		sb.append(sb2.reverse()).append(sb3.reverse());
		return sb.toString();
	}
}
