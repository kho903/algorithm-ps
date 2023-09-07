package programmers.lv1;

import java.util.*;

public class 카드뭉치 {

	public String solution(String[] cards1, String[] cards2, String[] goal) {
		String answer = "Yes";
		Queue<String> queue1 = new LinkedList<>(Arrays.asList(cards1));
		Queue<String> queue2 = new LinkedList<>(Arrays.asList(cards2));
		for (String g : goal) {
			if (queue1.size() > 0 && queue1.peek().equals(g)) {
				queue1.poll();
				continue;
			} else if (queue2.size() > 0 &&  queue2.peek().equals(g)) {
				queue2.poll();
				continue;
			}
			answer = "No";
			break;
		}
		return answer;
	}
}
