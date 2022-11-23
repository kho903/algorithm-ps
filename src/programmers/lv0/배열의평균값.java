package programmers.lv0;

import java.util.Arrays;

public class 배열의평균값 {
	public double solution(int[] numbers) {
		double sum = 0;
		for (int number : numbers)
			sum += number;
		return sum / numbers.length;
	}
}
