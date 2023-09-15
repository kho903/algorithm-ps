package boj.math._2525;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(stk.nextToken());
		int B = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(stk.nextToken());

		B += C;
		A += B / 60;
		B %= 60;
		if (A >= 24) A -= 24;
		StringBuilder sb = new StringBuilder();
		sb.append(A).append(' ').append(B);
		System.out.println(sb);
	}
}
