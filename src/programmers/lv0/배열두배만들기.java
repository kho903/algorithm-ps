package programmers.lv0;

public class 배열두배만들기 {

	public int[] solution(int[] numbers) {
		int N = numbers.length;
		for (int i = 0; i < N; i++)
			numbers[i] *= 2;

		return numbers;
	}
}
