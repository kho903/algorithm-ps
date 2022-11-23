package programmers.lv0;

public class 합성수찾기 {

	public int solution(int n) {
		int answer = 0;
		int x = 3;
		while (x <= n) {
			if (!d(x)) answer++;
			x++;
		}
		return answer;
	}

	public boolean d(int x) {
		int a = 2;
		while (a * a <= x) {
			if (x % a == 0)
				return false;
			a++;
		}
		return true;
	}
}
