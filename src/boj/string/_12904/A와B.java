package boj.string._12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		StringBuilder SS = new StringBuilder(S);
		StringBuilder TT = new StringBuilder(T);

		while (SS.length() < TT.length()) {
			if (TT.charAt(TT.length() - 1) == 'A') {
				TT.deleteCharAt(TT.length() - 1);
			} else if (TT.charAt(TT.length() - 1) == 'B') {
				TT.deleteCharAt(TT.length() - 1);
				TT.reverse();
			}
		}

		S = SS.toString();
		T = TT.toString();
		if (S.equals(T))
			System.out.println(1);
		else
			System.out.println(0);
	}
}
