package programmers.lv2;

import java.util.*;

public class 뒤에있는큰수찾기 {
	public int[] solution(int[] numbers) {
		int N = numbers.length;
		int[] answer = new int[N];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < N; i++) {
			if (stack.isEmpty() || numbers[i] < numbers[i - 1]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
					answer[stack.pop()] = numbers[i];
				}
				stack.push(i);
			}
		}

		while (!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}
		return answer;
	}
}