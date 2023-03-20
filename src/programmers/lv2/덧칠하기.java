package programmers.lv2;

public class 덧칠하기 {

	public int solution(int n, int m, int[] section) {
		int answer = 0;
		int max = 0;
		int N = section.length;
		for (int i = 0; i < N; i++) {
			if (max > section[i]) continue;
			answer++;
			max = section[i] + m;
		}

		return answer;
	}
}
