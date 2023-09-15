package boj.string._10798;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = new String[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine();
		}
		char[][] chars = new char[5][15];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				chars[i][j] = arr[i].charAt(j);
			}
		}


		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (chars[j][i] == '\0') continue;
				sb.append(chars[j][i]);
			}
		}
		System.out.println(sb);
	}
}
