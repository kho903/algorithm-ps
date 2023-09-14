package boj.string._4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			boolean jamoum = true;
			String s = br.readLine();
			if (s.equals("end")) break;
			int N = s.length();
			boolean aeiou = false;
			boolean flag = true;
			char prev = s.charAt(0);
			int ja = 0;
			int mo = 0;
			if (checkVowel(prev)) {
				aeiou = true;
				mo++;
			} else ja++;
			for (int i = 1; i < N; i++) {
				if (checkVowel(s.charAt(i))){
					aeiou = true;
					if (ja != 0) ja = 0;
					mo++;
				} else {
					if (mo != 0) mo = 0;
					ja++;
				}
				if (ja == 3 || mo == 3) {
					jamoum = false;
					break;
				}
				if (prev == s.charAt(i) && !((prev == 'e' && s.charAt(i) == 'e') || (prev == 'o' && s.charAt(i) == 'o'))) {
					flag = false;
					break;
				}
				prev = s.charAt(i);
			}
			if (flag && aeiou && jamoum) {
				sb.append('<').append(s).append('>').append(" is acceptable.").append('\n');
			} else {
				sb.append('<').append(s).append('>').append(" is not acceptable.").append('\n');
			}
		}
		System.out.println(sb);
	}

	private static boolean checkVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}
