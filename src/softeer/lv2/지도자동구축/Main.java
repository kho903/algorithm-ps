package softeer.lv2.지도자동구축;

import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long answer = (long)Math.pow(2, N);

		System.out.println((answer + 1) * (answer + 1));
	}
}
