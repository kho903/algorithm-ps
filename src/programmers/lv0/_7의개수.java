package programmers.lv0;

public class _7의개수 {

	public int solution(int[] array) {
		int answer = 0;
		for (int x : array) {
			int q = x;
			while (q > 0) {
				int t = q % 10;
				if (t == 7) answer++;
				q /= 10;
			}
		}
		return answer;
	}
}
