package boj.string._5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전화번호목록 {
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine();
			}
			Arrays.sort(arr);

			if (isPrefix(arr)) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.print(sb);
	}

	private static boolean isPrefix(String[] arr) {
		for (int i = 0; i < n - 1; i++) {
			if (arr[i + 1].startsWith(arr[i])) {
				return false;
			}
		}
		return true;
	}
}
