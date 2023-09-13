package boj.greedy._11000;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		Lecture[] lectures = new Lecture[N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			lectures[i] = new Lecture(s, e);
		}

		Arrays.sort(lectures, (l1, l2) -> l1.s == l2.s ? l1.e - l2.e : l1.s - l2.s);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(lectures[0].e);
		for (int i = 1; i < N; i++) {
			if (pq.peek() <= lectures[i].s) {
				pq.poll();
			}
			pq.offer(lectures[i].e);
		}
		System.out.println(pq.size());
	}
}

class Lecture {
	int s, e;

	public Lecture(int s, int e) {
		this.s = s;
		this.e = e;
	}
}