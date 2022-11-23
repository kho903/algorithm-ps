package programmers.lv0;

public class 제곱수판별하기 {
	public int solution(int n) {
		int a = 1;
		while (a * a <= n) {
			if (a * a == n)
				return 1;
			a++;
		}
		return 2;
	}
}
