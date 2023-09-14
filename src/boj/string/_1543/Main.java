package boj.string._1543;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String document = br.readLine();
		String find = br.readLine();
		String s = document.replaceAll(find, "1");

		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
