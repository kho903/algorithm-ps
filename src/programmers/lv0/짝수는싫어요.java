package programmers.lv0;

public class 짝수는싫어요 {
	public int[] solution(int n) {
		int N;
		if (n % 2 == 0) N = n / 2;
		else N = n / 2 + 1;
		int[] answer = new int[N];
		int x = 1;
		for (int i = 0; i < N; i++) {
			answer[i] = x;
			x += 2;
		}

		return answer;
	}
}
