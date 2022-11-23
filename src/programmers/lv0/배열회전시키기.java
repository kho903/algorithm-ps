package programmers.lv0;

public class 배열회전시키기 {
	public int[] solution(int[] numbers, String direction) {
		int N = numbers.length;
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			if (direction.equals("right")) {
				if (i == 0)
					answer[i] = numbers[N - 1];
				else answer[i] = numbers[i - 1];
			} else {
				if (i == N - 1)
					answer[i] = numbers[0];
				else answer[i] = numbers[i + 1];
			}
		}
		return answer;
	}
}
