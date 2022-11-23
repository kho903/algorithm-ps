package programmers.lv0;

public class 중복된숫자개수 {
	public int solution(int[] array, int n) {
		int answer = 0;
		for (int x : array)
			if (x == n) answer++;
		return answer;
	}
}
