package programmers.lv0;

import java.util.Arrays;

public class 최댓값만들기2 {

	public int solution(int[] numbers) {
		Arrays.sort(numbers);
		int N = numbers.length;
		if (numbers[0] < 0 && numbers[1] < 0) {
			if (numbers[0] * numbers[1] >= numbers[N - 1] * numbers[N - 2])
				return numbers[0] * numbers[1];
			return numbers[N - 1] * numbers[N - 2];
		}
		return numbers[N - 1] * numbers[N - 2];
	}
}
