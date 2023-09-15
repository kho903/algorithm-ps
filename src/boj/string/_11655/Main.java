package boj.string._11655;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int N = s.length();
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (char ch : chars) {
			if (!Character.isAlphabetic(ch)) {
				sb.append(ch);
			} else if (Character.isLowerCase(ch)) {
				if ((char)(ch + 13) > 'z')
					sb.append((char)(ch - 13));
				else
					sb.append((char)(ch + 13));
			} else {
				if ((char)(ch + 13) > 'Z')
					sb.append((char)(ch - 13));
				else
					sb.append((char)(ch + 13));
			}
		}
		System.out.println(sb);
	}
}
