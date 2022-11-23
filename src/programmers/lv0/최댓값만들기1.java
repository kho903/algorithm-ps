package programmers.lv0;

import java.util.Arrays;

public class 최댓값만들기1 {

	public int solution(int[] numbers) {
		Arrays.sort(numbers);
		int N = numbers.length;
		return numbers[N - 1] * numbers[N - 2];
	}
}
