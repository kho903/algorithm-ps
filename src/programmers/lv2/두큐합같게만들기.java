package programmers.lv2;

import java.util.*;

public class 두큐합같게만들기 {
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;

		int N = queue1.length;
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			q1.add(queue1[i]);
			q2.add(queue2[i]);
		}

		long sum1 = 0;
		long sum2 = 0;
		for (int i = 0; i < N; i++) {
			sum1 += queue1[i];
			sum2 += queue2[i];
		}

		while (sum1 != sum2) {
			if (answer > (queue1.length + queue2.length) * 2) return -1;

			if (sum1 < sum2) {
				int item = q2.poll();
				q1.add(item);
				sum1 += (long)item;
				sum2 -= (long)item;
			} else if (sum1 > sum2) {
				int item = q1.poll();
				q2.add(item);
				sum1 -= (long)item;
				sum2 += (long)item;
			} else {
				return answer;
			}
			answer++;
		}
		return answer;
	}
}
