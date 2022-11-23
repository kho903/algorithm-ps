package programmers.lv0;

import java.util.Arrays;

public class 배열자르기 {
	public int[] solution(int[] numbers, int num1, int num2) {
		int N = num2 - num1 + 1;
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = numbers[num1];
			num1++;
		}
		return answer;
		// return Arrays.copyOfRange(numbers, num1, num2 + 1);
	}
}
