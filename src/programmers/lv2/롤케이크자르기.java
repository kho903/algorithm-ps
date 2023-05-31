package programmers.lv2;

import java.util.*;

public class 롤케이크자르기 {
	public int solution(int[] topping) {
		int answer = 0;
		int N = topping.length;

		Map<Integer, Integer> first = new HashMap<>();
		Map<Integer, Integer> second = new HashMap<>();
		for (int x : topping) {
			first.put(x, first.getOrDefault(x, 0) + 1);
		}
		for (int x : topping) {
			second.put(x, second.getOrDefault(x, 0) + 1);
			if (first.get(x) == 1)
				first.remove(x);
			else
				first.put(x, first.get(x) - 1);

			if (first.size() == second.size())
				answer++;
		}
		return answer;
	}
}