package programmers.lv0;

public class 공던지기 {

	public int solution(int[] numbers, int k) {
		int x = 0;
		int cnt = 0;
		int answer = -1;
		int N = numbers.length;
		while (true) {
			cnt++;
			if (x >= N) {
				x -= N;
			}
			if (cnt == k) {
				answer = x + 1;
				break;
			}
			x += 2;
		}
		return answer;
	}
}
