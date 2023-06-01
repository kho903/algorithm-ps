package programmers.lv3;

import java.util.*;

public class 야근지수 {
	public long solution(int n, int[] works) {
		long answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int work : works) {
			pq.offer(work);
		}

		for (int i = 0; i < n; i++) {
			int poll = pq.poll();
			if (poll <= 0)
				break;
			pq.offer(poll - 1);
		}
		return calc(pq);
	}

	long calc(PriorityQueue<Integer> pq) {
		long sum = 0;
		while (!pq.isEmpty()) {
			sum += Math.pow(pq.poll(), 2);
		}
		return sum;
	}
}
