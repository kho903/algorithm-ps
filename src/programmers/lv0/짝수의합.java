package programmers.lv0;

public class 짝수의합 {
	public int solution(int n) {
		int answer = 0;
		for (int i = 2; i <= n; i += 2)
			answer += i;
		return answer;
	}
}
