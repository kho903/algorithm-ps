package programmers.lv0;

public class k의개수 {

	public int solution(int i, int j, int k) {
		int answer = 0;

		for (int w = i; w <= j; w++) {
			int q = w;
			while (q > 0) {
				int t = q % 10;
				if (t == k) answer++;
				q /= 10;
			}
		}
		return answer;
	}
}
