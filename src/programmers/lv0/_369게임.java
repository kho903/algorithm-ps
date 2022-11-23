package programmers.lv0;

public class _369게임 {

	public int solution(int order) {
		int answer = 0;
		while (order > 0) {
			int cur = order % 10;
			if (cur != 0 && cur % 3 == 0) answer++;
			order /= 10;
		}
		return answer;
	}
}
