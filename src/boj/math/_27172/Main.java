package boj.math._27172;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int SIZE = 1_000_001;
		int[] arr = new int[N];
		boolean[] card = new boolean[SIZE];
		int[] score = new int[SIZE];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
			card[arr[i]] = true;
		}

		for (int x : arr) {
			for (int i = x * 2; i < SIZE; i += x) {
				if (card[i]) {
					score[x]++;
					score[i]--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int x : arr) {
			sb.append(score[x]).append(" ");
		}
		System.out.println(sb);
	}
}
