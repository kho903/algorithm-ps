package boj.구현._1138;

import java.io.*;
import java.util.*;

public class 한줄로서기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int[] arr = new int[N + 1];
		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		List<Integer> line = new ArrayList<>();
		for (int i = N; i >= 1; i--) {
			line.add(arr[i], i);
		}
		for (Integer x : line) {
			System.out.print(x + " ");
		}

	}
}
