package boj.greedy._2864;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();
		String a = stk.nextToken();
		String b = stk.nextToken();
		a = a.replaceAll("6", "5");
		b = b.replaceAll("6", "5");

		sb.append(Integer.parseInt(a) + Integer.parseInt(b)).append(" ");

		a = a.replaceAll("5", "6");
		b = b.replaceAll("5", "6");
		sb.append(Integer.parseInt(a) + Integer.parseInt(b));
		System.out.println(sb);
	}
}
