package programmers.lv3;

import java.util.*;

public class 이중우선순위큐 {

	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		PriorityQueue<Integer> minQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

		for (String operation : operations) {
			String[] oper = operation.split(" ");
			int value = Integer.parseInt(oper[1]);
			if (minQ.size() == 0 && oper[0].equals("D"))
				continue;
			if (oper[0].equals("I")) {
				minQ.offer(value);
				maxQ.offer(value);
			} else if (value == 1) {
				int r = maxQ.poll();
				minQ.remove(r);
			} else {
				int r = minQ.poll();
				maxQ.remove(r);
			}
		}
		if (minQ.size() == 0) return answer;
		answer[0] = maxQ.poll();
		answer[1] = minQ.poll();
		return answer;
	}
}
