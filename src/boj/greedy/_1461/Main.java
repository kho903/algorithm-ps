package boj.greedy._1461;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> pqNegative = new PriorityQueue<>((o1, o2) -> o2 - o1);

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(stk.nextToken());
			if (a > 0)
				pq.offer(a);
			else pqNegative.offer(a * -1);
		}
		int max = 0;
		if (pq.isEmpty() && !pqNegative.isEmpty())
			max = pqNegative.peek();
		else if (!pq.isEmpty() && pqNegative.isEmpty())
			max = pq.peek();
		else max = Math.max(pq.peek(), pqNegative.peek());

		int ans = 0;
		while (!pq.isEmpty()) {
			ans += 2 * pq.poll();
			for (int i = 0; i < M - 1; i++) {
				if (pq.isEmpty())
					break;
				pq.poll();
			}
		}
		while (!pqNegative.isEmpty()) {
			ans += 2 * pqNegative.poll();
			for (int i = 0; i < M - 1; i++) {
				if (pqNegative.isEmpty())
					break;
				pqNegative.poll();
			}
		}

		System.out.println(ans - max);

	}
}
